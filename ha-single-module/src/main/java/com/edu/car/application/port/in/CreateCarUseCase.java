package com.edu.car.application.port.in;


import com.edu.car.application.domain.model.Car;

public interface CreateCarUseCase {

	Car execute(CreateCarCommand command);

	record CreateCarCommand(String name
	){}
}
