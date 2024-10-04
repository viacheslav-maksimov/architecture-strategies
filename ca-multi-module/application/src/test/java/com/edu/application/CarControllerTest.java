package com.edu.application;

import com.edu.application.configuration.CarConfiguration;
import com.edu.application.controller.CarController;
import com.edu.usecase.adapter.CarQueryRepository;
import com.edu.domain.model.Car;
import com.edu.persistence.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
@Import(CarConfiguration.class)
class CarControllerTest {
    @MockBean
    CarRepository carRepository;
    @MockBean
    CarQueryRepository carQueryRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetCarById() throws Exception {
        Mockito.when(carQueryRepository.getByCarId(1L)).thenReturn(Car.builder().name("test").stockNumber("XXX").build());

        this.mockMvc.perform(get("/cars/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":null,\"name\":\"test\",\"stockNumber\":\"XXX\"}")));
    }
}
