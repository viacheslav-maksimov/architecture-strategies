package com.edu.car.adapter.in.web;

import com.edu.car.adapter.in.web.dto.CarRequest;
import com.edu.car.common.WebAdapter;
import com.edu.car.application.port.in.CreateCarUseCase;
import com.edu.car.application.port.in.GetCarUseCase;
import com.edu.car.application.port.in.UpdateCarUseCase;
import com.edu.car.adapter.in.web.dto.CarResponse;
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
@WebAdapter
@RestController
@RequiredArgsConstructor
class CarController {

	private final CreateCarUseCase createCarUseCase;
	private final UpdateCarUseCase updateCarUseCase;
	private final GetCarUseCase getCarUseCase;
	private final CarDtoMapper carDtoMapper;

	@PostMapping(path = "/cars")
	CarResponse create(@Valid @RequestBody CarRequest carRequest) {
		var car = createCarUseCase.execute(new CreateCarUseCase.CreateCarCommand(carRequest.name()));
		return carDtoMapper.toDto(car);
	}

	@PutMapping("/{id}")
	CarResponse update(@PathVariable("id") Long id, @Valid @RequestBody CarRequest request){
		var car = updateCarUseCase.execute(new UpdateCarUseCase.UpdateCarCommand(id, request.name()));
		return carDtoMapper.toDto(car);
	}

	@GetMapping("/{id}")
	CarResponse get(@PathVariable("id") Long id){
		var car = getCarUseCase.execute(new GetCarUseCase.GetCarQuery(id));
		return carDtoMapper.toDto(car);
	}
}
