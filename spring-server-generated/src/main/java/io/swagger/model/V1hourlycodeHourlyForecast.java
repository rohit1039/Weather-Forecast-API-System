package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * V1hourlycodeHourlyForecast
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T06:40:29.743300367Z[GMT]")


public class V1hourlycodeHourlyForecast {
    @JsonProperty("hour_of_day")
    private BigDecimal hourOfDay = null;

    @JsonProperty("temperature")
    private BigDecimal temperature = null;

    @JsonProperty("precipitation")
    private BigDecimal precipitation = null;

    @JsonProperty("status")
    private String status = null;

    public V1hourlycodeHourlyForecast hourOfDay(BigDecimal hourOfDay) {
        this.hourOfDay = hourOfDay;
        return this;
    }

    /**
     * the forecasted hour (in 24h format)
     *
     * @return hourOfDay
     **/
    @Schema(example = "14", description = "the forecasted hour (in 24h format)")

    @Valid
    public BigDecimal getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(BigDecimal hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public V1hourlycodeHourlyForecast temperature(BigDecimal temperature) {
        this.temperature = temperature;
        return this;
    }

    /**
     * forecasted temperature at the hour, default in Celcius degree
     *
     * @return temperature
     **/
    @Schema(example = "19", description = "forecasted temperature at the hour, default in Celcius degree")

    @Valid
    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public V1hourlycodeHourlyForecast precipitation(BigDecimal precipitation) {
        this.precipitation = precipitation;
        return this;
    }

    /**
     * percentage chance of rain
     *
     * @return precipitation
     **/
    @Schema(example = "67", description = "percentage chance of rain")

    @Valid
    public BigDecimal getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(BigDecimal precipitation) {
        this.precipitation = precipitation;
    }

    public V1hourlycodeHourlyForecast status(String status) {
        this.status = status;
        return this;
    }

    /**
     * current weather status
     *
     * @return status
     **/
    @Schema(example = "Cloudy", description = "current weather status")

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        V1hourlycodeHourlyForecast v1hourlycodeHourlyForecast = (V1hourlycodeHourlyForecast) o;
        return Objects.equals(this.hourOfDay, v1hourlycodeHourlyForecast.hourOfDay) && Objects.equals(this.temperature,
                                                                                                      v1hourlycodeHourlyForecast.temperature) && Objects.equals(
                this.precipitation, v1hourlycodeHourlyForecast.precipitation) && Objects.equals(this.status,
                                                                                                v1hourlycodeHourlyForecast.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hourOfDay, temperature, precipitation, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V1hourlycodeHourlyForecast {\n");

        sb.append("    hourOfDay: ").append(toIndentedString(hourOfDay)).append("\n");
        sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
        sb.append("    precipitation: ").append(toIndentedString(precipitation)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
