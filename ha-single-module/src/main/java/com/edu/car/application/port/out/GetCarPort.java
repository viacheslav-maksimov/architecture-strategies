package com.edu.car.application.port.out;

import com.edu.car.application.domain.model.Car;

import java.util.Optional;

public interface GetCarPort {

	Optional<Car> get(Long id);
}
