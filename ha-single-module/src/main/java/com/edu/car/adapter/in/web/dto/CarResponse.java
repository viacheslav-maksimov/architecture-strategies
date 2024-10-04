package com.edu.car.adapter.in.web.dto;

import java.time.OffsetDateTime;

public record CarResponse(Long id, String name, String stockNumber, OffsetDateTime createdAt) {
}
