package com.skyapi.weatherforecast.location.exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(String message) {

        super(message);
    }
}
