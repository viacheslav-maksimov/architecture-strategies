package com.edu.usecase.adapter;

import com.edu.domain.model.Car;

public interface CarQueryRepository {
    Car getByCarId(Long id);
}
