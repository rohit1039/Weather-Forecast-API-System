package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-19T13:27:40.311592936Z[GMT]")
@RestController
public class V1ApiController implements V1Api {

    private static final Logger log = LoggerFactory.getLogger(V1ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<V1LocationsBody1> addLocation(
            @Parameter(in = ParameterIn.DEFAULT, description = "a JSON object that represents a location", required = true, schema = @Schema()) @Valid @RequestBody V1LocationsBody1 body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<V1LocationsBody1>(objectMapper.readValue(
                        "{\n  \"country_code\" : \"US\",\n  \"city_name\" : \"Los Angeles\",\n  \"location_code\" : \"LACA_US\",\n  \"country_name\" : \"United States of America\",\n  \"region_name\" : \"California\",\n  \"enabled\" : true\n}",
                        V1LocationsBody1.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<V1LocationsBody1>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<V1LocationsBody1>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteLocation(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2003> getDailyForecastByLocationCode(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2003>(objectMapper.readValue(
                        "{\n  \"location\" : \"New York, New York, US\",\n  \"daily_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2003.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2003>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2003>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2004> getFullWeatherByIPAddress() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2004>(objectMapper.readValue(
                        "{\n  \"realtime\" : {\n    \"precipitation\" : 50,\n    \"last_updated\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"temperature\" : 12,\n    \"humidity\" : 72,\n    \"wind_speed\" : 8,\n    \"status\" : \"Sunny\"\n  },\n  \"location\" : \"New York, New York, US\",\n  \"daily_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  } ],\n  \"hourly_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2004.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2004>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2004>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2004> getFullWeatherByLocationCode(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2004>(objectMapper.readValue(
                        "{\n  \"realtime\" : {\n    \"precipitation\" : 50,\n    \"last_updated\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"temperature\" : 12,\n    \"humidity\" : 72,\n    \"wind_speed\" : 8,\n    \"status\" : \"Sunny\"\n  },\n  \"location\" : \"New York, New York, US\",\n  \"daily_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  } ],\n  \"hourly_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2004.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2004>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2004>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<V1LocationsBody1> getLocation(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<V1LocationsBody1>(objectMapper.readValue(
                        "{\n  \"country_code\" : \"US\",\n  \"city_name\" : \"Los Angeles\",\n  \"location_code\" : \"LACA_US\",\n  \"country_name\" : \"United States of America\",\n  \"region_name\" : \"California\",\n  \"enabled\" : true\n}",
                        V1LocationsBody1.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<V1LocationsBody1>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<V1LocationsBody1>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2001> getRealtimeByIPAddress() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2001>(objectMapper.readValue(
                        "{\n  \"precipitation\" : 50,\n  \"last_updated\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"temperature\" : 12,\n  \"humidity\" : 72,\n  \"location\" : \"New York City, New York, United States of America\",\n  \"wind_speed\" : 8,\n  \"status\" : \"Sunny\"\n}",
                        InlineResponse2001.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2001>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2001>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2001> getRealtimeByLocationCode(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2001>(objectMapper.readValue(
                        "{\n  \"precipitation\" : 50,\n  \"last_updated\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"temperature\" : 12,\n  \"humidity\" : 72,\n  \"location\" : \"New York City, New York, United States of America\",\n  \"wind_speed\" : 8,\n  \"status\" : \"Sunny\"\n}",
                        InlineResponse2001.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2001>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2001>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> listAllLocations() {

        Location location1 = new Location("NYC_USA", "New York City", "New York", "US", "United States of America",
                                          true);

        Location location2 = new Location("LACA_USA", "Los Angeles", "California", "US", "United States of America",
                                          true);

        List<Location> locations = List.of(location1, location2);

        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    public ResponseEntity<InlineResponse2003> listDailyForecastByIPAddress() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2003>(objectMapper.readValue(
                        "{\n  \"location\" : \"New York, New York, US\",\n  \"daily_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2003.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2003>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2003>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2002> listHourlyForecastByIPAddress() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2002>(objectMapper.readValue(
                        "{\n  \"location\" : \"New York, New York, US\",\n  \"hourly_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2002.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2002>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2002>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2002> listHourlyForecastByLocationCode(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2002>(objectMapper.readValue(
                        "{\n  \"location\" : \"New York, New York, US\",\n  \"hourly_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2002.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2002>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2002>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2003> updateDailyForecast(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code,
            @Parameter(in = ParameterIn.DEFAULT, description = "a JSON object that represents the daily weather forecast data that needs to be updated", required = true, schema = @Schema()) @Valid @RequestBody DailyCodeBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2003>(objectMapper.readValue(
                        "{\n  \"location\" : \"New York, New York, US\",\n  \"daily_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2003.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2003>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2003>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2004> updateFullWeather(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code,
            @Parameter(in = ParameterIn.DEFAULT, description = "a JSON object that represents the full weather forecast information that needs to be updated", required = true, schema = @Schema()) @Valid @RequestBody FullCodeBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2004>(objectMapper.readValue(
                        "{\n  \"realtime\" : {\n    \"precipitation\" : 50,\n    \"last_updated\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"temperature\" : 12,\n    \"humidity\" : 72,\n    \"wind_speed\" : 8,\n    \"status\" : \"Sunny\"\n  },\n  \"location\" : \"New York, New York, US\",\n  \"daily_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"month\" : 8,\n    \"min_temp\" : 12,\n    \"max_temp\" : 12,\n    \"day_of_month\" : 8,\n    \"status\" : \"Cloudy\"\n  } ],\n  \"hourly_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2004.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2004>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2004>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2002> updateHourlyForecast(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code,
            @Parameter(in = ParameterIn.DEFAULT, description = "a JSON object that represents the hourly weather forecast data that needs to be updated", required = true, schema = @Schema()) @Valid @RequestBody HourlyCodeBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2002>(objectMapper.readValue(
                        "{\n  \"location\" : \"New York, New York, US\",\n  \"hourly_forecast\" : [ {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  }, {\n    \"precipitation\" : 67,\n    \"temperature\" : 19,\n    \"hour_of_day\" : 14,\n    \"status\" : \"Cloudy\"\n  } ]\n}",
                        InlineResponse2002.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2002>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2002>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<V1LocationsBody> updateLocation(
            @Parameter(in = ParameterIn.DEFAULT, description = "a JSON object that represents the location information that needs to be updated", required = true, schema = @Schema()) @Valid @RequestBody V1LocationsBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<V1LocationsBody>(objectMapper.readValue(
                        "{\n  \"country_code\" : \"US\",\n  \"city_name\" : \"Los Angeles\",\n  \"location_code\" : \"LACA_US\",\n  \"country_name\" : \"United States of America\",\n  \"region_name\" : \"California\",\n  \"enabled\" : true\n}",
                        V1LocationsBody.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<V1LocationsBody>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<V1LocationsBody>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RealtimeCodeBody> updateRealtimeWeather(
            @Parameter(in = ParameterIn.PATH, description = "code of the location", required = true, schema = @Schema()) @PathVariable("code") String code,
            @Parameter(in = ParameterIn.DEFAULT, description = "a JSON object that represents the realtime weather data that needs to be updated", required = true, schema = @Schema()) @Valid @RequestBody RealtimeCodeBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<RealtimeCodeBody>(objectMapper.readValue(
                        "{\n  \"precipitation\" : 50,\n  \"last_updated\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"temperature\" : 12,\n  \"humidity\" : 72,\n  \"location\" : \"New York City, New York, United States of America\",\n  \"wind_speed\" : 8,\n  \"status\" : \"Sunny\"\n}",
                        RealtimeCodeBody.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<RealtimeCodeBody>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<RealtimeCodeBody>(HttpStatus.NOT_IMPLEMENTED);
    }

}
