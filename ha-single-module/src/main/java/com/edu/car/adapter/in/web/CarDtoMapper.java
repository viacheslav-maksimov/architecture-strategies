package com.edu.car.adapter.in.web;

import com.edu.car.application.domain.model.Car;
import com.edu.car.adapter.in.web.dto.CarResponse;
import org.springframework.stereotype.Component;

@Component
class CarDtoMapper {

	CarResponse toDto(Car car) {
		return new CarResponse(car.getId(), car.getName(), car.getStockNumber(), car.getCreatedAt());
	}

}
