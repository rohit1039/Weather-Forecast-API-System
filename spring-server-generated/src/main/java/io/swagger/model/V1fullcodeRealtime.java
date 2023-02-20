package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * V1fullcodeRealtime
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T06:40:29.743300367Z[GMT]")


public class V1fullcodeRealtime   {
  @JsonProperty("temperature")
  private BigDecimal temperature = null;

  @JsonProperty("humidity")
  private BigDecimal humidity = null;

  @JsonProperty("precipitation")
  private BigDecimal precipitation = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("wind_speed")
  private BigDecimal windSpeed = null;

  @JsonProperty("last_updated")
  private OffsetDateTime lastUpdated = null;

  public V1fullcodeRealtime temperature(BigDecimal temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * current temperature of the location, default in Celcius degree
   * @return temperature
   **/
  @Schema(example = "12", description = "current temperature of the location, default in Celcius degree")
  
    @Valid
    public BigDecimal getTemperature() {
    return temperature;
  }

  public void setTemperature(BigDecimal temperature) {
    this.temperature = temperature;
  }

  public V1fullcodeRealtime humidity(BigDecimal humidity) {
    this.humidity = humidity;
    return this;
  }

  /**
   * percentage of humidity
   * @return humidity
   **/
  @Schema(example = "72", description = "percentage of humidity")
  
    @Valid
    public BigDecimal getHumidity() {
    return humidity;
  }

  public void setHumidity(BigDecimal humidity) {
    this.humidity = humidity;
  }

  public V1fullcodeRealtime precipitation(BigDecimal precipitation) {
    this.precipitation = precipitation;
    return this;
  }

  /**
   * percentage chance of rain
   * @return precipitation
   **/
  @Schema(example = "50", description = "percentage chance of rain")
  
    @Valid
    public BigDecimal getPrecipitation() {
    return precipitation;
  }

  public void setPrecipitation(BigDecimal precipitation) {
    this.precipitation = precipitation;
  }

  public V1fullcodeRealtime status(String status) {
    this.status = status;
    return this;
  }

  /**
   * current weather status
   * @return status
   **/
  @Schema(example = "Sunny", description = "current weather status")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public V1fullcodeRealtime windSpeed(BigDecimal windSpeed) {
    this.windSpeed = windSpeed;
    return this;
  }

  /**
   * current wind speed (default unit is km/h)
   * @return windSpeed
   **/
  @Schema(example = "8", description = "current wind speed (default unit is km/h)")
  
    @Valid
    public BigDecimal getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(BigDecimal windSpeed) {
    this.windSpeed = windSpeed;
  }

  public V1fullcodeRealtime lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * the last time weather data is updated
   * @return lastUpdated
   **/
  @Schema(description = "the last time weather data is updated")
  
    @Valid
    public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1fullcodeRealtime v1fullcodeRealtime = (V1fullcodeRealtime) o;
    return Objects.equals(this.temperature, v1fullcodeRealtime.temperature) &&
        Objects.equals(this.humidity, v1fullcodeRealtime.humidity) &&
        Objects.equals(this.precipitation, v1fullcodeRealtime.precipitation) &&
        Objects.equals(this.status, v1fullcodeRealtime.status) &&
        Objects.equals(this.windSpeed, v1fullcodeRealtime.windSpeed) &&
        Objects.equals(this.lastUpdated, v1fullcodeRealtime.lastUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(temperature, humidity, precipitation, status, windSpeed, lastUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1fullcodeRealtime {\n");
    
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    humidity: ").append(toIndentedString(humidity)).append("\n");
    sb.append("    precipitation: ").append(toIndentedString(precipitation)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    windSpeed: ").append(toIndentedString(windSpeed)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
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
