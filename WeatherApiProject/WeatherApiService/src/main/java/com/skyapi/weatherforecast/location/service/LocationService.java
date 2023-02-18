package com.skyapi.weatherforecast.location.service;

import com.skyapi.weatherforecast.common.Location;

import java.util.List;

public interface LocationService {

    Location addLocation(Location location);

    List<Location> getLocations();

}
