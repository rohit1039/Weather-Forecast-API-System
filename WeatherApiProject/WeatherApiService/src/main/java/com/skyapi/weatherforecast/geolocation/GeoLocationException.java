package com.skyapi.weatherforecast.geolocation;

public class GeoLocationException extends RuntimeException {

    public GeoLocationException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeoLocationException(String s) {
        super(s);
    }
}
