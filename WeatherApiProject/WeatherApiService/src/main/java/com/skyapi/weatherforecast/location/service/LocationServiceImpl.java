package com.skyapi.weatherforecast.location.service;

import org.springframework.stereotype.Service;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {

        this.locationRepository = locationRepository;
    }

    public Location addLocation(Location location) {

        Location savedLocation = this.locationRepository.save(location);

        return savedLocation;
    }
}
