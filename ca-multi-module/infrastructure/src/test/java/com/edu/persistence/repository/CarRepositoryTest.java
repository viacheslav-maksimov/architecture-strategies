package com.edu.persistence.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CarRepositoryTest extends BaseRepositoryTest{
    @Autowired
    private CarRepository carRepository;

    @Test
    public void shouldGetByCarId() {
        var id = 100L;
        var car = carRepository.findById(id);
        Assertions.assertThat(car).isNotNull();
    }
}
