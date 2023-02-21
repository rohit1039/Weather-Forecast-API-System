package com.skyapi.weatherforecast.common;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "realtimeweather")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealtimeWeather {

    private String location;
    private Integer temperature;
    private Integer humidity;
    private Integer precipitation;
    private String status;
    private Integer windSpeed;
    private LocalDateTime lastUpdated;

}
