package com.edu.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void generateSKU() {
        var car = Car.builder().build();

        car.generateStockNumber();

        Assertions.assertThat(car.getStockNumber()).isNotBlank();
    }
}