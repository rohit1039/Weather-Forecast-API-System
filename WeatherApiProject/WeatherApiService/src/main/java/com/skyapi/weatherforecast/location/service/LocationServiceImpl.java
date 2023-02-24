package com.skyapi.weatherforecast.location.service;

import com.skyapi.weatherforecast.common.Location;
import com.skyapi.weatherforecast.location.exception.LocationNotFoundException;
import com.skyapi.weatherforecast.location.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location addLocation(Location location) {

        LOGGER.info("Inside addLocation method");

        Location savedLocation = this.locationRepository.save(location);

        return savedLocation;
    }

    @Override
    public List<Location> getLocations() {

        LOGGER.info("Inside get all locations");

        return this.locationRepository.findUntrashedLocations();
    }

    @Override
    public Location getLocationByCode(String code) {

        LOGGER.info("Inside get locations by code");

        return this.locationRepository.findLocation(code);
    }

    @Override
    public Location update(Location locationInRequest) {

        LOGGER.info("Inside update method");

        Location locationInDB = this.locationRepository.findLocation(locationInRequest.getCode());

        if (isNull(locationInDB)) {

            throw new LocationNotFoundException(
                    "Location not found with the given code: " + locationInRequest.getCode());
        }

        Location locationToSave = locationInDB.toBuilder()
                                              .cityName(locationInRequest.getCityName())
                                              .regionName(locationInRequest.getRegionName())
                                              .countryName(locationInRequest.getCountryName())
                                              .countryCode(locationInRequest.getCountryCode())
                                              .enabled(locationInRequest.isEnabled())
                                              .build();

        Location updatedLocation = this.locationRepository.save(locationToSave);

        return updatedLocation;
    }

    @Override
    public void delete(String code) {

        LOGGER.info("Inside delete method");

        Location locationInDB = this.locationRepository.findLocation(code);

        if (isNull(locationInDB)) {

            throw new LocationNotFoundException("No location found with the given code: " + code);
        }
        this.locationRepository.trashByCode(code);

        LOGGER.info("Location trashed successfully!");
    }
}
