package com.edu.car.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

public record CarRequest(@NotNull String name) {
}
