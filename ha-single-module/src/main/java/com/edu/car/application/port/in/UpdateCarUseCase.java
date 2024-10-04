package com.edu.car.application.port.in;


import com.edu.car.application.domain.model.Car;

public interface UpdateCarUseCase {

	Car execute(UpdateCarCommand command);

	record UpdateCarCommand(
			Long id,
			String name
	){}
}
