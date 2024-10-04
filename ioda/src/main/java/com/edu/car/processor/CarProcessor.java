package com.edu.car.processor;

import com.edu.car.dto.CarRequest;
import com.edu.car.dto.CarResponse;
import com.edu.car.domain.model.Car;
import com.edu.car.domain.StockGenerator;
import com.edu.car.repository.CarRepository;
import lombok.RequiredArgsConstructor;

/*
* Integrates operations, without describing logic
* */
@RequiredArgsConstructor
public class CarProcessor  {

	private final CarRepository repository;
	private final StockGenerator stockGenerator;

	public CarResponse createCar(CarRequest request) {

		var car = Car.builder().name(request.name()).build();
		stockGenerator.generateStockNumber(car);
		var saveCar = repository.save(car);
		/*
		* do some work, for instance, call another service
		* */
		return new CarResponse(saveCar.getId(), saveCar.getName(), saveCar.getStockNumber(), saveCar.getCreatedAt());
	}

	public CarResponse updateCar(Long id, CarRequest request) {
		return null;
	}

	public CarResponse getCar(Long id){
		return null;
	}
}




