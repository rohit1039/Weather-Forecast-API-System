package com.skyapi.weatherforecast.location.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.exception.LocationNotFoundException;
import com.skyapi.weatherforecast.location.service.LocationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LocationApiController.class)
public class LocationApiControllerTests {

    private static final String END_POINT_PATH = "/v1/locations";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private LocationService locationService;

    @Test
    public void testAddShouldReturn400BadRequest() throws Exception {

        Location location = new Location();

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json").content(bodyContent))
               .andExpect(status().isBadRequest())
               .andDo(print());
    }

    @Test
    public void testAddShouldReturn201Created() throws Exception {

        Location location = Location.builder()
                                    .locationCode("NYC_USA")
                                    .cityName("New York City")
                                    .regionName("New York")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();

        Mockito.when(locationService.addLocation(location)).thenReturn(location);

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json").content(bodyContent))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.location_code", is("NYC_USA")))
               .andExpect(jsonPath("$.city_name", is("New York City")))
               .andDo(print());
    }

    @Test
    public void testListShouldReturn204NoContent() throws Exception {

        Mockito.when(locationService.getLocations()).thenReturn(Collections.emptyList());

        mockMvc.perform(get(END_POINT_PATH)).andExpect(status().isNoContent()).andDo(print());
    }

    @Test
    public void testListShouldReturn200OK() throws Exception {

        Location location1 = Location.builder()
                                     .locationCode("NYC_USA")
                                     .cityName("New York City")
                                     .regionName("New York")
                                     .countryCode("US")
                                     .countryName("United States of America")
                                     .enabled(true)
                                     .build();

        Location location2 = Location.builder()
                                     .locationCode("LACA_USA")
                                     .cityName("Los Angeles")
                                     .regionName("California")
                                     .countryCode("US")
                                     .countryName("United States of America")
                                     .enabled(true)
                                     .build();

        Mockito.when(locationService.getLocations()).thenReturn(List.of(location1, location2));

        mockMvc.perform(get(END_POINT_PATH))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$[0].location_code", is("NYC_USA")))
               .andExpect(jsonPath("$[0].city_name", is("New York City")))
               .andExpect(jsonPath("$[1].location_code", is("LACA_USA")))
               .andExpect(jsonPath("$[1].city_name", is("Los Angeles")))
               .andDo(print());
    }

    @Test
    public void testGetShouldReturn405MethodNotAllowed() throws Exception {

        String requestURI = END_POINT_PATH + "/ABCDEF";

        mockMvc.perform(post(requestURI)).andExpect(status().isMethodNotAllowed()).andDo(print());
    }

    @Test
    public void testGetShouldReturn404NotFound() throws Exception {

        String requestURI = END_POINT_PATH + "/ABCDEF";

        mockMvc.perform(get(requestURI)).andExpect(status().isNotFound()).andDo(print());
    }

    @Test
    public void testGetShouldReturn200OK() throws Exception {

        String code = "LACA_USA";
        String requestURI = END_POINT_PATH + "/" + code;

        Location location = Location.builder()
                                    .locationCode("LACA_USA")
                                    .cityName("Los Angeles")
                                    .regionName("California")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();

        Mockito.when(locationService.getLocationByCode(code)).thenReturn(location);

        mockMvc.perform(get(requestURI))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$.location_code", is(code)))
               .andExpect(jsonPath("$.city_name", is("Los Angeles")))
               .andDo(print());
    }

    @Test
    public void testUpdateShouldReturn404NotFound() throws Exception {

        Location location = Location.builder()
                                    .locationCode("ABCDEF")
                                    .cityName("Los Angeles")
                                    .regionName("California")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();

        Mockito.when(locationService.update(location)).thenThrow(new LocationNotFoundException("No location found"));

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(put(END_POINT_PATH).contentType("application/json").content(bodyContent))
               .andExpect(status().isNotFound())
               .andDo(print());
    }

    @Test
    public void testUpdateShouldReturn400BadRequest() throws Exception {

        Location location = Location.builder()
                                    .cityName("Los Angeles")
                                    .regionName("California")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(put(END_POINT_PATH).contentType("application/json").content(bodyContent))
               .andExpect(status().isBadRequest())
               .andDo(print());
    }

    @Test
    public void testUpdateShouldReturn200OK() throws Exception {

        Location location = Location.builder()
                                    .locationCode("NYC_USA")
                                    .cityName("New York City")
                                    .regionName("New York")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();

        Mockito.when(locationService.update(location)).thenReturn(location);

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(put(END_POINT_PATH).contentType("application/json").content(bodyContent))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.location_code", is("NYC_USA")))
               .andExpect(jsonPath("$.city_name", is("New York City")))
               .andDo(print());
    }

    @Test
    public void testDeleteShouldReturn404NotFound() throws Exception {

        String code = "LACA_USA";
        String requestURI = END_POINT_PATH + "/" + code;

        Mockito.doThrow(LocationNotFoundException.class).when(locationService).delete(code);

        mockMvc.perform(delete(requestURI)).andExpect(status().isNotFound()).andDo(print());
    }

    @Test
    public void testDeleteShouldReturn204NoContent() throws Exception {

        String code = "LACA_USA";
        String requestURI = END_POINT_PATH + "/" + code;

        Mockito.doNothing().when(locationService).delete(code);

        mockMvc.perform(delete(requestURI)).andExpect(status().isNoContent()).andDo(print());
    }
}