package com.edu.car.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CarRepository extends JpaRepository<Car, Long> {
}
