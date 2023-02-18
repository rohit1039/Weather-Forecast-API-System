package com.skyapi.weatherforecast.location.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.repository.LocationRepository;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class LocationRepositoryTests {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void testAddLocation_Success() {

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

}
