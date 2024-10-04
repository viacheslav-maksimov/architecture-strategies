package com.edu.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CarRequest(@NotBlank String name) {
}
