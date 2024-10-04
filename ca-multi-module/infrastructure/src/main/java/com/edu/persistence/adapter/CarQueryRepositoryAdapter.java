package com.edu.persistence.adapter;

import com.edu.domain.model.Car;
import com.edu.persistence.exception.NotFoundEntityException;
import com.edu.persistence.repository.CarRepository;
import com.edu.usecase.adapter.CarQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarQueryRepositoryAdapter implements CarQueryRepository {
    private final CarRepository carRepository;

    @Override
    public Car getByCarId(Long id) {
        var carEntity = carRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(Car.class, id));
        return Car.builder().id(carEntity.getId()).name(carEntity.getName()).stockNumber(carEntity.getSku()).build();
    }
}
