package com.skyapi.weatherforecast.location.service;

import com.skyapi.weatherforecast.common.Location;

import java.util.List;

public interface LocationService {

    Location addLocation(Location location);

    List<Location> getLocations();

    Location getLocationByCode(String code);

    Location update(Location locationInRequest);

    void delete(String locationCode);
}
