package com.edu.car.adapter.out.persistence;

import com.edu.car.application.domain.model.Car;
import org.springframework.stereotype.Component;

@Component
class CarEntityMapper {

	Car toDomain(CarEntity carEntity) {
		return Car.builder().id(carEntity.getId())
				.name(carEntity.getName())
				.stockNumber(carEntity.getStockNumber())
				.createdAt(carEntity.getCreatedAt())
				.build();
	}

	CarEntity toEntity(Car car) {
		return CarEntity.builder().id(car.getId())
				.name(car.getName()).stockNumber(car.getStockNumber()).build();
	}

}
