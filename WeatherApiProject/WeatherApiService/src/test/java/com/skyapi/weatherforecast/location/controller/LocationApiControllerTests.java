package com.skyapi.weatherforecast.location.controller;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatusCode;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationApiControllerTests {

    @Mock
    private LocationService locationService;

    @InjectMocks
    private LocationApiController locationApiController;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Add Location - Success Scenario")
    public void test_AddLocation_201Created() {

        Location expectedResponse = Location.builder()
                                            .code("IN_ODIA")
                                            .countryCode("IN")
                                            .countryName("INDIA")
                                            .cityName("Karanjia")
                                            .enabled(true)
                                            .build();

        Mockito.when(locationService.addLocation(Mockito.any())).thenReturn(expectedResponse);

        Location actualResponse = this.locationApiController.addLocation(expectedResponse).getBody();

        HttpStatusCode actualStatusCode = this.locationApiController.addLocation(expectedResponse).getStatusCode();

        assertEquals(expectedResponse, actualResponse);

        assertEquals(HttpStatusCode.valueOf(201), actualStatusCode);
    }

    @Test
    @DisplayName("Add Location - Failure Scenario")
    public void test_AddLocation_400BadRequest() {

        Location expectedResponse = Location.builder().build();

        Mockito.when(locationService.addLocation(Mockito.any())).thenReturn(expectedResponse);

        Location actualResponse = this.locationApiController.addLocation(expectedResponse).getBody();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Get Locations - Success Scenario")
    public void test_GetLocations_200_Ok() {

        Location location1 = Location.builder()
                                     .code("IN_ODIA")
                                     .countryCode("IN")
                                     .countryName("INDIA")
                                     .regionName("ODISHA")
                                     .cityName("Karanjia")
                                     .enabled(true)
                                     .trashed(false)
                                     .build();

        Location location2 = Location.builder()
                                     .code("NYC_USA")
                                     .cityName("New York City")
                                     .regionName("New York")
                                     .countryCode("US")
                                     .countryName("United States of America")
                                     .trashed(true)
                                     .enabled(true)
                                     .build();

        Mockito.when(locationService.getLocations()).thenReturn(List.of(location1, location2));

        HttpStatusCode actualStatusCode = this.locationApiController.getLocations().getStatusCode();

        assertEquals(HttpStatusCode.valueOf(200), actualStatusCode);
    }

    @Test
    @DisplayName("Get Locations - Failure Scenario")
    public void test_GetLocations_204_NoContent() {

        Mockito.when(locationService.getLocations()).thenReturn(Collections.emptyList());

        HttpStatusCode actualStatusCode = this.locationApiController.getLocations().getStatusCode();

        assertEquals(HttpStatusCode.valueOf(204), actualStatusCode);
    }

}
