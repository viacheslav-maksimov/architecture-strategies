package com.edu.car.application.domain.service;

import com.edu.car.application.domain.model.Car;
import com.edu.car.application.port.in.UpdateCarUseCase;
import com.edu.car.application.port.out.GetCarPort;
import com.edu.car.application.port.out.UpdateCarPort;
import com.edu.car.common.UseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UpdateCarService implements UpdateCarUseCase {
    private final UpdateCarPort updateCarPort;
    private final GetCarPort getCarPort;

    @Override
    public Car execute(UpdateCarCommand command) {
        return getCarPort.get(command.id())
                .map(car -> car.update(command.name()))
                .map(updateCarPort::update)
                .orElseThrow(EntityNotFoundException::new);
    }
}
