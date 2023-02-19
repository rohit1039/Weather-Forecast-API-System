package com.skyapi.weatherforecast.location.repository;

import com.skyapi.weatherforecast.common.Location;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {

    @Query(" SELECT l FROM Location l where l.trashed=false ")
    List<Location> findUntrashedLocations();

    @Query(" SELECT l from Location l where l.trashed=false AND l.locationCode=?1 ")
    Location findLocation(String code);

    @Modifying
    @Query("UPDATE Location SET trashed = true WHERE locationCode = ?1")
    public void trashByCode(String code);

}
