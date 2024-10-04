package com.edu.application.dto;

import com.edu.domain.model.Car;
import com.edu.persistence.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarDtoMapper {

	public CarResponse toDto(Car car) {
		return new CarResponse(car.getId(), car.getName(), car.getStockNumber());
	}

	public Car toDomain(CarRequest dto) {
		return Car.builder()
				.name(dto.name()).build();
	}
	public Car toDomain(Long id, CarRequest dto) {
		return Car.builder()
				.id(id)
				.name(dto.name()).build();
	}

}
