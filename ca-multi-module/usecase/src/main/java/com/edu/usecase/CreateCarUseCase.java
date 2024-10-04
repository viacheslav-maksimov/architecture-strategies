package com.edu.usecase;

import com.edu.usecase.adapter.CarMutationRepository;
import com.edu.domain.model.Car;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CreateCarUseCase {
    private final CarMutationRepository carMutationRepository;
    public Car execute(Car car){
        car.generateStockNumber();
        return carMutationRepository.create(car);
    }
}
