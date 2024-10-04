package com.edu.car.function.car;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

public class CreateCarUseCase {

    @Repository
    interface CarRepository extends JpaRepository<Car, Long> {
    }
    public record CarRequest(@NotNull String name) {
    }
    public record CarResponse(Long id, String name, String stockNumber, OffsetDateTime createdAt) {
    }

    @RestController
    public class CreateCarController {
        CarRepository repository;

        @PostMapping(path = "/cars")
        CarResponse create(@Valid @RequestBody CarRequest request) {
            var car = Car.builder().name(request.name()).build();
            car.generateStockNumber();
            repository.save(car);
            return new CarResponse(car.getId(), car.getName(), car.getStockNumber(), car.getCreatedAt());
        }
    }
}
