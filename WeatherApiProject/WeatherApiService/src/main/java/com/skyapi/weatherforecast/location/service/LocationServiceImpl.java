package com.skyapi.weatherforecast.location.service;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {

        this.locationRepository = locationRepository;
    }

    public Location addLocation(Location location) {

        Location savedLocation = this.locationRepository.save(location);

        return savedLocation;
    }

    @Override
    public List<Location> getLocations() {

        return this.locationRepository.findUntrashedLocations();
    }
}
