package com.skyapi.weatherforecast.realtime.repository;

import com.skyapi.weatherforecast.common.RealtimeWeather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RealtimeWeatherRepositoryTests {

    @Autowired
    private RealtimeWeatherRepository realtimeWeatherRepository;

    @Test
    public void testUpdateRealTimeWeatherData() {

        String locationCode = "NYC_US";

        RealtimeWeather realtimeWeather = this.realtimeWeatherRepository.findById(locationCode).get();

        realtimeWeather.setTemperature(10);
        realtimeWeather.setHumidity(60);
        realtimeWeather.setPrecipitation(70);
        realtimeWeather.setStatus("CLOUDY");
        realtimeWeather.setWindSpeed(10);
        realtimeWeather.setLastUpdated(LocalDateTime.now());
        realtimeWeather.setLocationCode(locationCode);

        RealtimeWeather realtimeWeatherToSave = this.realtimeWeatherRepository.save(realtimeWeather);

        assertThat(realtimeWeatherToSave.getHumidity()).isEqualTo(60);
    }
}
