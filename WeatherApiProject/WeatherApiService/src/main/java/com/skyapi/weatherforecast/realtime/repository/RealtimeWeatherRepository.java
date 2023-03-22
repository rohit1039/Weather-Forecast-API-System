package com.skyapi.weatherforecast.realtime.repository;

import com.skyapi.weatherforecast.common.RealtimeWeather;
import org.springframework.data.repository.CrudRepository;

public interface RealtimeWeatherRepository extends CrudRepository<RealtimeWeather, String> {
}
