package com.edu.usecase;

import com.edu.usecase.adapter.CarMutationRepository;
import com.edu.domain.model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCarUseCaseTest {

    @InjectMocks
    CreateCarUseCase createCarUseCase;
    @Mock
    CarMutationRepository carMutationRepository;

    @Test
    void shouldCreateCar() {
        var car = Car.builder().name("test").build();
        var createdCar = Car.builder().id(1L).name("test").stockNumber("eb5d6899-6a45-4bc5-9779-34f6a6032b28 ").build();
        when(carMutationRepository.create(car)).thenReturn(createdCar);

        var actualCar = createCarUseCase.execute(car);

        Assertions.assertThat(actualCar.getId()).isNotNull();
        Assertions.assertThat(actualCar.getStockNumber()).isNotNull();
    }
}