package com.skyapi.weatherforecast.location.repository;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.common.RealtimeWeather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class LocationRepositoryTests {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void testAddLocation_Success() {

        Location location = new Location();

        location.setCode("DELHI_IN");
        location.setCityName("New Delhi");
        location.setRegionName("Maharastra");
        location.setCountryCode("IN");
        location.setCountryName("INDIA");
        location.setEnabled(true);

        Location savedLocation = this.locationRepository.save(location);

        assertThat(savedLocation).isNotNull();
        assertThat(savedLocation.getCode()).isEqualTo(location.getCode());
    }

    @Test
    public void testAddLocation_Failure() {

        Location location = Location.builder()
                                    .code("NYC_USA")
                                    .cityName("New York City")
                                    .regionName("New York")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();

        Location savedLocation = this.locationRepository.save(location);

        assertThat(savedLocation).isNotNull();
        assertThat(savedLocation.getCode()).isEqualTo(location.getCode());
    }

    @Test
    public void testGetLocations_Success() {

        List<Location> getLocations = this.locationRepository.findUntrashedLocations();

        assertThat(getLocations).isNotEmpty();

        getLocations.forEach(System.out::println);
    }

    @Test
    public void testGetLocationByCode_Failure() {

        String code = "ABCD";

        Location location = this.locationRepository.findLocation(code);

        assertThat(location).isNull();
    }

    @Test
    public void testGetLocationByCode_Success() {

        String code = "NYC_USA";

        Location location = this.locationRepository.findLocation(code);

        assertThat(location).isNotNull();
        assertThat(location.getCode()).isEqualTo(code);
    }

    @Test
    public void testTrashSuccess() {

        String code = "LACA_USA";

        this.locationRepository.trashByCode(code);

        Location location = this.locationRepository.findLocation(code);

        assertThat(location).isNull();
    }

    @Test
    public void testAddRealTimeWeatherData() {

        String code = "DL_IN";

        Location location = this.locationRepository.findLocation(code);

        RealtimeWeather realtimeWeather = location.getRealtimeWeather();

        if (realtimeWeather == null) {
            realtimeWeather = new RealtimeWeather();
            realtimeWeather.setLocation(location);
            location.setRealtimeWeather(realtimeWeather);
        }

        realtimeWeather.setTemperature(42);
        realtimeWeather.setHumidity(50);
        realtimeWeather.setPrecipitation(45);
        realtimeWeather.setStatus("SUNNY");
        realtimeWeather.setWindSpeed(12);
        realtimeWeather.setLastUpdated(LocalDateTime.now());
        realtimeWeather.setLocationCode(code);

        Location locationToSave = this.locationRepository.save(location);

        assertThat(locationToSave.getRealtimeWeather().getLocationCode()).isEqualTo(code);
    }

}
