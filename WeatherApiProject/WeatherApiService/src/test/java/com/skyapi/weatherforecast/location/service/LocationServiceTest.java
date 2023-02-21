package com.skyapi.weatherforecast.location.service;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.exception.LocationNotFoundException;
import com.skyapi.weatherforecast.location.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationService locationService = new LocationServiceImpl();

    @BeforeEach
    public void init() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddLocation() {

        Location location = mockLocation();

        Mockito.when(this.locationRepository.save(location)).thenReturn(mockLocation());

        Location savedLocation = this.locationService.addLocation(location);

        assertEquals(location.getCode(), savedLocation.getCode());

        verify(locationRepository, times(1)).save(location);

    }

    @Test
    public void testGetLocations() {

        Mockito.when(this.locationRepository.findUntrashedLocations()).thenReturn(mockListOfLocations());

        List<Location> locations = this.locationService.getLocations();

        assertThat(locations).isNotEmpty();

        assertThat(locations.size()).isEqualTo(mockListOfLocations().size());

        verify(locationRepository, times(1)).findUntrashedLocations();
    }

    @Test
    public void testGetLocationByCode() {

        Mockito.when(this.locationRepository.findLocation(any(String.class))).thenReturn(mockLocation());

        Location getLocationByCode = this.locationService.getLocationByCode("NYC_USA");

        assertThat("NYC_USA").isEqualTo(getLocationByCode.getCode());

        verify(locationRepository, times(1)).findLocation("NYC_USA");
    }

    @Test
    public void testUpdateLocation() {

        Mockito.when(this.locationRepository.findLocation("NYC_USA")).thenReturn(mockLocation());

        Mockito.when(this.locationRepository.save(mockLocation())).thenReturn(mockLocation());

        mockLocation().setCode("ABC");
        mockLocation().setCountryName("INDIA");

        Location updatedLocation = this.locationService.update(mockLocation());

        assertThat(updatedLocation.getCode()).isEqualTo(mockLocation().getCode());

        verify(locationRepository, times(1)).findLocation("NYC_USA");
        verify(locationRepository, times(1)).save(mockLocation());
    }

    @Test
    public void testUpdateLocation_throwsException() {

        assertThrows(LocationNotFoundException.class, () -> this.locationService.update(mockLocation()));

    }

    @Test
    public void testDeleteLocation() {

        Mockito.when(this.locationRepository.findLocation(mockLocation().getCode())).thenReturn(mockLocation());

        doNothing().when(this.locationRepository).trashByCode(mockLocation().getCode());

        this.locationService.delete(mockLocation().getCode());
    }

    @Test
    public void testDeleteLocation_throwsException() {

        assertThrows(LocationNotFoundException.class, () -> this.locationService.delete(mockLocation().getCode()));

    }

    private Location mockLocation() {

        Location location = Location.builder()
                                    .code("NYC_USA")
                                    .cityName("New York City")
                                    .regionName("New York")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();
        return location;
    }

    private List<Location> mockListOfLocations() {

        Location location1 = Location.builder()
                                     .code("NYC_USA")
                                     .cityName("New York City")
                                     .regionName("New York")
                                     .countryCode("US")
                                     .countryName("United States of America")
                                     .enabled(true)
                                     .build();

        Location location2 = Location.builder()
                                     .code("LACA_USA")
                                     .cityName("Los Angeles")
                                     .regionName("California")
                                     .countryCode("US")
                                     .countryName("United States of America")
                                     .enabled(true)
                                     .build();

        return new ArrayList<>(List.of(location1, location2));
    }
}
