package com.edu.car.application.domain.model;

import com.edu.car.application.port.in.UpdateCarUseCase;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class Car {
    Long id;
    String name;
    String stockNumber;
    OffsetDateTime createdAt;

    public void generateStockNumber() {
        if (stockNumber == null) {
            this.stockNumber = UUID.randomUUID().toString();
        }
    }

    public Car update(String name) {
        this.name = name;
        return this;
    }
}
