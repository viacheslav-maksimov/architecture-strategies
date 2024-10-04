package com.edu.car.domain.car;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "cars")
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String stockNumber;
	@CreatedDate
	OffsetDateTime createdAt;

	public void generateStockNumber() {
		if (stockNumber == null) {
			this.stockNumber = UUID.randomUUID().toString();
		}
	}
}
