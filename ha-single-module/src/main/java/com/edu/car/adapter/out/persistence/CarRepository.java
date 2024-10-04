package com.edu.car.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface CarRepository extends JpaRepository<CarEntity, Long> {
}
