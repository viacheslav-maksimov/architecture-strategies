package com.edu.application.configuration;

import com.edu.usecase.adapter.CarMutationRepository;
import com.edu.usecase.adapter.CarQueryRepository;
import com.edu.usecase.CreateCarUseCase;
import com.edu.usecase.GetCarUseCase;
import com.edu.usecase.UpdateCarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.edu.persistence.adapter"})
public class CarConfiguration {

    @Bean
    public CreateCarUseCase createCar(CarMutationRepository carMutationRepository){
        return new CreateCarUseCase(carMutationRepository);
    }
    @Bean
    public UpdateCarUseCase updateCar(CarMutationRepository carMutationRepository,
                                      CarQueryRepository carQueryRepository){
        return new UpdateCarUseCase(carMutationRepository, carQueryRepository);
    }
    @Bean
    public GetCarUseCase getCar(CarQueryRepository carQueryRepository){
        return new GetCarUseCase(carQueryRepository);
    }
}
