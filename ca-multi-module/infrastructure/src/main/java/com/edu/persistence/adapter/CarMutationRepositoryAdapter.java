package com.edu.persistence.adapter;

import com.edu.domain.model.Car;
import com.edu.persistence.entity.CarEntity;
import com.edu.persistence.repository.CarRepository;
import com.edu.usecase.adapter.CarMutationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarMutationRepositoryAdapter implements CarMutationRepository {
    private final CarRepository carRepository;

    public Car create(Car car){
        var entity = carRepository.save(
                CarEntity.builder().name(car.getName()).sku(car.getStockNumber()).build());
        return Car.builder().id(entity.getId()).name(entity.getName()).stockNumber(entity.getSku()).build();
    }

    @Override
    public Car update(Car car) {
        var entity = carRepository.save(
                CarEntity.builder().name(car.getName()).sku(car.getStockNumber()).build());
        return Car.builder().id(entity.getId()).name(entity.getName()).stockNumber(entity.getSku()).build();
    }
}
