package com.edu.car.application.port.in;


import com.edu.car.application.domain.model.Car;

public interface GetCarUseCase {

	Car execute(GetCarQuery id);
	record GetCarQuery(Long carId) {
	}
}
