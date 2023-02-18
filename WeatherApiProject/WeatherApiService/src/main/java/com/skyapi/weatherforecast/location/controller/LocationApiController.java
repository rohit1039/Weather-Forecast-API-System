package com.skyapi.weatherforecast.location.controller;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/locations")
public class LocationApiController {

    private LocationService locationService;

    public LocationApiController(LocationService locationService) {

        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {

        Location addedLocation = this.locationService.addLocation(location);

        return new ResponseEntity<>(addedLocation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getLocations() {

        List<Location> locations = this.locationService.getLocations();

        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
}
