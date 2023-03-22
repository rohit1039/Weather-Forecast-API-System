package com.skyapi.weatherforecast.geolocation;

import com.ip2location.IP2Location;
import com.ip2location.IPResult;
import com.skyapi.weatherforecast.common.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class GeolocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeolocationService.class);

    private static final String DBPath = "ip2locdb/IP2LOCATION-LITE-DB3.BIN";
    private static final IP2Location ipLocater = new IP2Location();

    public GeolocationService() throws IOException {

        try {
            ipLocater.Open(DBPath);
        }
        catch (IOException exception) {
            LOGGER.error(exception.getLocalizedMessage(), exception);
        }
    }

    private static Location getLocation(String ipAddress) throws IOException {

        try {
            IPResult ipResult = ipLocater.IPQuery(ipAddress);

            if (!Objects.equals(ipResult.getStatus(), "OK")) {
                throw new GeoLocationException("Geolocation failed with status: " + ipResult.getStatus());
            }

            return new Location(ipResult.getCity(), ipResult.getRegion(), ipResult.getCountryLong(),
                                ipResult.getCountryShort());
        }
        catch (IOException exception) {
            throw new GeoLocationException("Error in query in GeolocationDB", exception);
        }
    }
}
