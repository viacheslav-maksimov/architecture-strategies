package com.edu.car.adapter.out.persistence;

import com.edu.car.application.domain.model.Car;
import com.edu.car.application.port.out.CreateCarPort;
import com.edu.car.application.port.out.GetCarPort;
import com.edu.car.application.port.out.UpdateCarPort;
import com.edu.car.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
class CarPersistenceAdapter implements
		CreateCarPort,
		UpdateCarPort,
		GetCarPort
{

	private final CarRepository carRepository;
	private final CarEntityMapper carEntityMapper;

	@Override
	public Car create(Car car) {
		var entity = carEntityMapper.toEntity(car);
		var savedEntity = carRepository.save(entity);
		return carEntityMapper.toDomain(savedEntity);
	}

	@Override
	public Optional<Car> get(Long id) {
		var entity = carRepository.findById(id);
		return entity.map(carEntityMapper::toDomain);
	}

	@Override
	public Car update(Car car) {
		var entity = carEntityMapper.toEntity(car);
		var savedEntity = carRepository.save(entity);
		return carEntityMapper.toDomain(savedEntity);
	}

}
