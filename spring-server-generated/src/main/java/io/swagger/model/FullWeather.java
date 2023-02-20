package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.V1dailycodeDailyForecast;
import io.swagger.model.V1fullcodeRealtime;
import io.swagger.model.V1hourlycodeHourlyForecast;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FullWeather
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T06:40:29.743300367Z[GMT]")


public class FullWeather   {
  @JsonProperty("location")
  private String location = null;

  @JsonProperty("realtime")
  private V1fullcodeRealtime realtime = null;

  @JsonProperty("hourly_forecast")
  @Valid
  private List<V1hourlycodeHourlyForecast> hourlyForecast = null;

  @JsonProperty("daily_forecast")
  @Valid
  private List<V1dailycodeDailyForecast> dailyForecast = null;

  public FullWeather location(String location) {
    this.location = location;
    return this;
  }

  /**
   * name of location, in form of \"city name, state/region name, country name\"
   * @return location
   **/
  @Schema(example = "New York, New York, US", description = "name of location, in form of \"city name, state/region name, country name\"")
  
    public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public FullWeather realtime(V1fullcodeRealtime realtime) {
    this.realtime = realtime;
    return this;
  }

  /**
   * Get realtime
   * @return realtime
   **/
  @Schema(description = "")
  
    @Valid
    public V1fullcodeRealtime getRealtime() {
    return realtime;
  }

  public void setRealtime(V1fullcodeRealtime realtime) {
    this.realtime = realtime;
  }

  public FullWeather hourlyForecast(List<V1hourlycodeHourlyForecast> hourlyForecast) {
    this.hourlyForecast = hourlyForecast;
    return this;
  }

  public FullWeather addHourlyForecastItem(V1hourlycodeHourlyForecast hourlyForecastItem) {
    if (this.hourlyForecast == null) {
      this.hourlyForecast = new ArrayList<V1hourlycodeHourlyForecast>();
    }
    this.hourlyForecast.add(hourlyForecastItem);
    return this;
  }

  /**
   * Get hourlyForecast
   * @return hourlyForecast
   **/
  @Schema(description = "")
      @Valid
    public List<V1hourlycodeHourlyForecast> getHourlyForecast() {
    return hourlyForecast;
  }

  public void setHourlyForecast(List<V1hourlycodeHourlyForecast> hourlyForecast) {
    this.hourlyForecast = hourlyForecast;
  }

  public FullWeather dailyForecast(List<V1dailycodeDailyForecast> dailyForecast) {
    this.dailyForecast = dailyForecast;
    return this;
  }

  public FullWeather addDailyForecastItem(V1dailycodeDailyForecast dailyForecastItem) {
    if (this.dailyForecast == null) {
      this.dailyForecast = new ArrayList<V1dailycodeDailyForecast>();
    }
    this.dailyForecast.add(dailyForecastItem);
    return this;
  }

  /**
   * Get dailyForecast
   * @return dailyForecast
   **/
  @Schema(description = "")
      @Valid
    public List<V1dailycodeDailyForecast> getDailyForecast() {
    return dailyForecast;
  }

  public void setDailyForecast(List<V1dailycodeDailyForecast> dailyForecast) {
    this.dailyForecast = dailyForecast;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FullWeather fullWeather = (FullWeather) o;
    return Objects.equals(this.location, fullWeather.location) &&
        Objects.equals(this.realtime, fullWeather.realtime) &&
        Objects.equals(this.hourlyForecast, fullWeather.hourlyForecast) &&
        Objects.equals(this.dailyForecast, fullWeather.dailyForecast);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, realtime, hourlyForecast, dailyForecast);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FullWeather {\n");
    
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    realtime: ").append(toIndentedString(realtime)).append("\n");
    sb.append("    hourlyForecast: ").append(toIndentedString(hourlyForecast)).append("\n");
    sb.append("    dailyForecast: ").append(toIndentedString(dailyForecast)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
