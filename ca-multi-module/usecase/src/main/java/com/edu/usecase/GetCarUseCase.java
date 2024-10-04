package com.edu.usecase;

import com.edu.usecase.adapter.CarQueryRepository;
import com.edu.domain.model.Car;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class GetCarUseCase {
    private final CarQueryRepository carQueryRepository;

    public Car execute(Long id){
        return carQueryRepository.getByCarId(id);
    }
}
