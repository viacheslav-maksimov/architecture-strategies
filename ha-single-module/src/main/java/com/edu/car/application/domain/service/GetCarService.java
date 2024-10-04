package com.edu.car.application.domain.service;

import com.edu.car.application.domain.model.Car;
import com.edu.car.application.port.in.GetCarUseCase;
import com.edu.car.application.port.out.GetCarPort;
import com.edu.car.common.UseCase;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetCarService implements GetCarUseCase {
    private final GetCarPort getCarPort;

    public Car execute(GetCarQuery query){
        return getCarPort.get(query.carId())
                .orElseThrow(EntityNotFoundException::new);
    }
}
