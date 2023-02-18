package com.skyapi.weatherforecast.location.service;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.exception.LocationNotFoundException;
import com.skyapi.weatherforecast.location.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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

    @Override
    public Location getLocationsByCode(String code) {

        return this.locationRepository.findLocation(code);
    }

    @Override
    public Location update(Location locationInRequest) {

        Location locationInDB = this.locationRepository.findLocation(locationInRequest.getLocationCode());

        if (locationInDB == null) {

            throw new LocationNotFoundException(
                    "Location not found with given location_code: " + locationInRequest.getLocationCode());

        }

        locationInDB.setCityName(locationInRequest.getCityName());
        locationInDB.setRegionName(locationInRequest.getRegionName());
        locationInDB.setCountryName(locationInRequest.getCountryName());
        locationInDB.setCountryCode(locationInRequest.getCountryCode());
        locationInDB.setEnabled(locationInRequest.isEnabled());

        Location updatedLocation = this.locationRepository.save(locationInDB);

        return updatedLocation;
    }

    @Override
    public void delete(String code) {

        Location locationInDB = this.locationRepository.findLocation(code);

        if (locationInDB == null) {

            throw new LocationNotFoundException("No location found with the given location_code: " + code);
        }

        this.locationRepository.trashByCode(code);
    }
}
