package com.skyapi.weatherforecast.common;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "realtime_weather")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RealtimeWeather {

    @Id
    @Column(name = "location_code")
    private String locationCode;
    @Column(nullable = false)
    private Integer temperature;
    @Column(nullable = false)
    private Integer humidity;
    @Column(nullable = false)
    private Integer precipitation;
    @Column(length = 50)
    private String status;
    @Column(nullable = false)
    private Integer windSpeed;
    private LocalDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name = "location_code")
    @MapsId
    private Location location;

    @Override
    public String toString() {
        return "RealtimeWeather{" + "locationCode='" + locationCode + '\'' + ", temperature=" + temperature + ", humidity=" + humidity + ", precipitation=" + precipitation + ", status='" + status + '\'' + ", windSpeed=" + windSpeed + ", lastUpdated=" + lastUpdated + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RealtimeWeather that = (RealtimeWeather) o;

        if (!Objects.equals(locationCode, that.locationCode)) {
            return false;
        }
        if (!Objects.equals(temperature, that.temperature)) {
            return false;
        }
        if (!Objects.equals(humidity, that.humidity)) {
            return false;
        }
        if (!Objects.equals(precipitation, that.precipitation)) {
            return false;
        }
        if (!Objects.equals(status, that.status)) {
            return false;
        }
        if (!Objects.equals(windSpeed, that.windSpeed)) {
            return false;
        }
        if (!Objects.equals(lastUpdated, that.lastUpdated)) {
            return false;
        }
        return Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        int result = locationCode != null ? locationCode.hashCode() : 0;
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (precipitation != null ? precipitation.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (windSpeed != null ? windSpeed.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
