package com.edu.usecase.adapter;

import com.edu.domain.model.Car;

public interface CarMutationRepository {
    Car create(Car model);
    Car update(Car model);
}
