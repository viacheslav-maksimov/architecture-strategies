package com.edu.application.controller;

import com.edu.application.dto.CarDtoMapper;
import com.edu.application.dto.CarRequest;
import com.edu.application.dto.CarResponse;
import com.edu.usecase.CreateCarUseCase;
import com.edu.usecase.GetCarUseCase;
import com.edu.usecase.UpdateCarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cars")
@RestController
@RequiredArgsConstructor
public class CarController {

    private final CreateCarUseCase createCarUseCase;
    private final UpdateCarUseCase updateCarUseCase;
    private final GetCarUseCase getCarUseCase;
    private final CarDtoMapper dtoMapper;

    @PostMapping
    CarResponse create(CarRequest request){
        var car = createCarUseCase.execute(dtoMapper.toDomain(request));
        return dtoMapper.toDto(car);
    }

    @PutMapping("/{id}")
    CarResponse update(@PathVariable("id") Long id, CarRequest request){
        var car = updateCarUseCase.execute(dtoMapper.toDomain(id, request));
        return dtoMapper.toDto(car);
    }

    @GetMapping("/{id}")
    CarResponse get(@PathVariable("id") Long id){
        var car = getCarUseCase.execute(id);
        return dtoMapper.toDto(car);
    }
}
