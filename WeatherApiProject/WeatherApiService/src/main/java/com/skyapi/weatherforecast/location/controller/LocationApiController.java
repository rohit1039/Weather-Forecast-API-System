package com.skyapi.weatherforecast.location.controller;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.service.LocationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(value = "/v1/locations")
@Validated
public class LocationApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationApiController.class);

    private final LocationService locationService;

    public LocationApiController(LocationService locationService) {

        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<?> addLocation(@RequestBody @Valid Location location) {

        HttpStatusCode statusCode = checkForUniqueLocationCode(location).getStatusCode();

        if (statusCode.is2xxSuccessful()) {

            Location addedLocation = this.locationService.addLocation(location);

            LOGGER.info("Location saved successfully!");

            return new ResponseEntity<>(addedLocation, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Location already exists with location code: " + location.getCode(), statusCode);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getLocations() {

        List<Location> locations = this.locationService.getLocations();

        if (locations.isEmpty()) {

            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Location> getLocationByCode(@PathVariable @Size(min = 3, max = 12) String code) {

        Location location = this.locationService.getLocationByCode(code);

        if (isNull(location)) {

            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Location> updateLocation(@RequestBody @Valid Location locationInRequest) {

        Location updatedLocation = this.locationService.update(locationInRequest);

        LOGGER.info("Location updated with location code: {}", updatedLocation.getCode());

        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteLocation(@PathVariable("code") @Size(min = 3, max = 12) String code) {

        this.locationService.delete(code);

        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<?> checkForUniqueLocationCode(Location addedLocation) {

        if (!isNull(this.locationService.getLocationByCode(addedLocation.getCode()))) {

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
