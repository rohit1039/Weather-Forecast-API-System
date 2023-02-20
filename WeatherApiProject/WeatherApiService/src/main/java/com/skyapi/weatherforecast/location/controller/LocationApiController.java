package com.skyapi.weatherforecast.location.controller;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.service.LocationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Location> addLocation(@Valid @RequestBody Location location) {

        Location addedLocation = this.locationService.addLocation(location);

        LOGGER.info("Location saved successfully!");

        return new ResponseEntity<>(addedLocation, HttpStatus.CREATED);
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
    public ResponseEntity<Location> getLocationByCode(
            @PathVariable @Size(max = 12) String code) {

        Location location = this.locationService.getLocationByCode(code);

        if (location == null) {

            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Location> updateLocation(@RequestBody @Valid Location locationInRequest) {

        Location updatedLocation = this.locationService.update(locationInRequest);

        LOGGER.info("Location updated with: {}", updatedLocation.getLocationCode());

        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteLocation(
            @PathVariable("code") @Size(max = 12) String code) {

        this.locationService.delete(code);

        return ResponseEntity.noContent().build();
    }

}
