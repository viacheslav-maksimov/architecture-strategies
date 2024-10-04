package com.edu.car.application;

import com.edu.car.dto.CarRequest;
import com.edu.car.dto.CarResponse;
import com.edu.car.processor.CarProcessor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
class CarController {

	CarProcessor carProcessor;

	@PostMapping(path = "/cars")
	CarResponse create(@Valid @RequestBody CarRequest request) {
		return carProcessor.createCar(request);
	}

	@PutMapping("/{id}")
	CarResponse update(@PathVariable("id") Long id, @Valid @RequestBody CarRequest request){
		return carProcessor.updateCar(id, request);
	}

	@GetMapping("/{id}")
	CarResponse get(@PathVariable("id") Long id){
		return carProcessor.getCar(id);
	}
}
