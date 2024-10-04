package com.edu.car.dto;

import jakarta.validation.constraints.NotNull;

public record CarRequest(@NotNull String name) {
}
