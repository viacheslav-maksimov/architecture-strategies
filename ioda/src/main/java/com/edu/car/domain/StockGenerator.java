package com.edu.car.domain;

import com.edu.car.domain.model.Car;

import java.util.UUID;

public class StockGenerator {
    public void generateStockNumber(Car car) {
        car.setStockNumber(UUID.randomUUID().toString());
    }
}
