package com.edu.car.application.port.out;

import com.edu.car.application.domain.model.Car;

public interface CreateCarPort {

	Car create(Car car);
}