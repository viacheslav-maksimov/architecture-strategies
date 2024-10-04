package com.edu.persistence.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;
import org.testcontainers.utility.DockerImageName;

import java.util.stream.Stream;

import static java.util.Objects.isNull;

@Slf4j
public class TestContainersPostgresInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String IMAGE_NAME = "postgres:13-alpine";
    private static final String PG_HOST_PROPERTY = "spring.datasource.url";
    private static final String PG_USERNAME_PROPERTY = "spring.datasource.username";
    private static final String PG_PASS_PROPERTY = "spring.datasource.password";

    private static PostgreSQLContainer postgres;

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        if (isNull(postgres) || !postgres.isCreated()) {
            log.info("Starting TestContainers Redis initialization.");
            postgres = new PostgreSQLContainer<>(DockerImageName.parse(IMAGE_NAME));
            Startables.deepStart(Stream.of(postgres)).join();
        } else {
            log.info("Skipping TestContainers PG initialization. Container is already created. Updating properties.");
        }
        context.getEnvironment().getPropertySources().addFirst(new MapPropertySource("testcontainers-postgres",
                ImmutableMap.of(
                        PG_HOST_PROPERTY, postgres.getJdbcUrl(),
                        PG_USERNAME_PROPERTY, postgres.getUsername(),
                        PG_PASS_PROPERTY, postgres.getPassword()
                )));
    }
}
