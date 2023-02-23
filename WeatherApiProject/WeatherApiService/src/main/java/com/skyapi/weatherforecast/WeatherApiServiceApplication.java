package com.skyapi.weatherforecast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WeatherApiServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherApiServiceApplication.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(WeatherApiServiceApplication.class, args);

        LOGGER.info("Application currently running: {}", applicationContext.getId());
    }
}
