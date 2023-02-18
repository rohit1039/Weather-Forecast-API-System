package com.skyapi.weatherforecast.location.repository;

import com.skyapi.weatherforecast.common.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, String> {

    @Query("SELECT l FROM Location l where l.trashed=false")
    List<Location> findUntrashedLocations();

}
