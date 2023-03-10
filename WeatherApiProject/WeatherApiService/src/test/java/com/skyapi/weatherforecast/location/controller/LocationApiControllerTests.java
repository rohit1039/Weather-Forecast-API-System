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
    public void testAddShouldReturn201Created() throws Exception {

        Location location = Location.builder()
                                    .code("NYC_USA")
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
               .andExpect(jsonPath("$.code", is("NYC_USA")))
               .andExpect(jsonPath("$.city_name", is("New York City")))
               .andDo(print());
    }

    @Test
    public void testValidateRequestBodyLocationCodeNotNull() throws Exception {

        Location location = Location.builder()
                                    .cityName("New York City")
                                    .regionName("New York")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();

        Mockito.when(locationService.addLocation(location)).thenReturn(location);

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json").content(bodyContent))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.code", is("Location code cannot be null")))
               .andDo(print());
    }

    @Test
    public void testValidateRequestBodyLocationCodeLength() throws Exception {

        Location location = Location.builder()
                                    .code("XY")
                                    .cityName("New York City")
                                    .regionName("New York")
                                    .countryCode("US")
                                    .countryName("United States of America")
                                    .enabled(true)
                                    .build();

        Mockito.when(locationService.addLocation(location)).thenReturn(location);

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json").content(bodyContent))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.code", is("Location code must have 3-12 characters")))
               .andDo(print());
    }

    @Test
    public void testAddShouldReturn400BadRequestAllFieldsInvalid() throws Exception {

        Location location = new Location();
        location.setRegionName("");

        String bodyContent = mapper.writeValueAsString(location);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json").content(bodyContent))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.code", is("Location code cannot be null")))
               .andExpect(jsonPath("$.cityName", is("City name cannot be null")))
               .andExpect(jsonPath("$.regionName", is("Region name must have 3-128 characters")))
               .andExpect(jsonPath("$.countryName", is("Country name cannot be null")))
               .andExpect(jsonPath("$.countryCode", is("Country code cannot be null")))
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

        Mockito.when(locationService.getLocations()).thenReturn(List.of(location1, location2));

        mockMvc.perform(get(END_POINT_PATH))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$[0].code", is("NYC_USA")))
               .andExpect(jsonPath("$[0].city_name", is("New York City")))
               .andExpect(jsonPath("$[1].code", is("LACA_USA")))
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
                                    .code("LACA_USA")
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
               .andExpect(jsonPath("$.code", is(code)))
               .andExpect(jsonPath("$.city_name", is("Los Angeles")))
               .andDo(print());
    }

    @Test
    public void testUpdateShouldReturn404NotFound() throws Exception {

        Location location = Location.builder()
                                    .code("ABCDEF")
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
                                    .code("NYC_USA")
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
               .andExpect(jsonPath("$.code", is("NYC_USA")))
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