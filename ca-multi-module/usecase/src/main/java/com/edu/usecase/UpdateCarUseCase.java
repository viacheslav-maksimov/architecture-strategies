package com.edu.usecase;

import com.edu.usecase.adapter.CarMutationRepository;
import com.edu.usecase.adapter.CarQueryRepository;
import com.edu.domain.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
public class UpdateCarUseCase {
    private final CarMutationRepository carMutationRepository;
    private final CarQueryRepository carQueryRepository;

    @Transactional
    public Car execute(Car car){
        var existedCar = carQueryRepository.getByCarId(car.getId());
        existedCar.update(car);
        return carMutationRepository.update(existedCar);
    }
}
