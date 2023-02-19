package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * RealtimeCodeBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-19T13:27:40.311592936Z[GMT]")


public class RealtimeCodeBody {
    @JsonProperty("location")
    private String location = null;

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

    public RealtimeCodeBody location(String location) {
        this.location = location;
        return this;
    }

    /**
     * name of location, in form of \"city name, state/region name, country name\"
     *
     * @return location
     **/
    @Schema(example = "New York City, New York, United States of America", description = "name of location, in form of \"city name, state/region name, country name\"")

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public RealtimeCodeBody temperature(BigDecimal temperature) {
        this.temperature = temperature;
        return this;
    }

    /**
     * current temperature of the location, default in Celsius degree
     *
     * @return temperature
     **/
    @Schema(example = "12", description = "current temperature of the location, default in Celsius degree")

    @Valid
    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public RealtimeCodeBody humidity(BigDecimal humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     * percentage of humidity
     *
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

    public RealtimeCodeBody precipitation(BigDecimal precipitation) {
        this.precipitation = precipitation;
        return this;
    }

    /**
     * percentage chance of rain
     *
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

    public RealtimeCodeBody status(String status) {
        this.status = status;
        return this;
    }

    /**
     * current weather status
     *
     * @return status
     **/
    @Schema(example = "Sunny", description = "current weather status")

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RealtimeCodeBody windSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    /**
     * current wind speed (default unit is km/h)
     *
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

    public RealtimeCodeBody lastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * the last time weather data is updated
     *
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
        RealtimeCodeBody realtimeCodeBody = (RealtimeCodeBody) o;
        return Objects.equals(this.location, realtimeCodeBody.location) && Objects.equals(this.temperature,
                                                                                          realtimeCodeBody.temperature) && Objects.equals(
                this.humidity, realtimeCodeBody.humidity) && Objects.equals(this.precipitation,
                                                                            realtimeCodeBody.precipitation) && Objects.equals(
                this.status, realtimeCodeBody.status) && Objects.equals(this.windSpeed,
                                                                        realtimeCodeBody.windSpeed) && Objects.equals(
                this.lastUpdated, realtimeCodeBody.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, temperature, humidity, precipitation, status, windSpeed, lastUpdated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RealtimeCodeBody {\n");

        sb.append("    location: ").append(toIndentedString(location)).append("\n");
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
