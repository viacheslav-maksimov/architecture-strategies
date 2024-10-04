package com.edu.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class Car {
    Long id;
    String name;
    String stockNumber;

    public void generateStockNumber() {
        if (stockNumber == null) {
            this.stockNumber = UUID.randomUUID().toString();
        }
    }

    public void update(Car car) {
        this.name = car.getName();
    }
}
