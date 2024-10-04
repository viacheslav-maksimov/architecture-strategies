package com.edu.car.application.domain.service;

import com.edu.car.application.domain.model.Car;
import com.edu.car.application.port.in.CreateCarUseCase;
import com.edu.car.application.port.out.CreateCarPort;
import com.edu.car.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateCarService implements CreateCarUseCase {

	private final CreateCarPort createCarPort;

	@Override
	public Car execute(CreateCarCommand command) {

		var car = Car.builder().name(command.name()).build();
		car.generateStockNumber();
		return createCarPort.create(car);
	}
}




