package com.skyapi.weatherforecast.location.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatusCode;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.service.LocationService;

public class LocationApiControllerTests {

    @Mock private LocationService locationService;

    @InjectMocks private LocationApiController locationApiController;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
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
    public void test_AddLocation_400BadRequest() {

        Location expectedResponse = Location.builder().build();

        Mockito.when(locationService.addLocation(Mockito.any())).thenReturn(expectedResponse);

        Location actualResponse = this.locationApiController.addLocation(expectedResponse).getBody();

        assertEquals(expectedResponse, actualResponse);
    }

}
