package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DailyWeather
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T06:40:29.743300367Z[GMT]")


public class DailyWeather {
    @JsonProperty("location")
    private String location = null;

    @JsonProperty("daily_forecast")
    @Valid
    private List<V1dailycodeDailyForecast> dailyForecast = null;

    public DailyWeather location(String location) {
        this.location = location;
        return this;
    }

    /**
     * name of location, in form of \"city name, state/region name, country name\"
     *
     * @return location
     **/
    @Schema(example = "New York, New York, US", description = "name of location, in form of \"city name, state/region name, country name\"")

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DailyWeather dailyForecast(List<V1dailycodeDailyForecast> dailyForecast) {
        this.dailyForecast = dailyForecast;
        return this;
    }

    public DailyWeather addDailyForecastItem(V1dailycodeDailyForecast dailyForecastItem) {
        if (this.dailyForecast == null) {
            this.dailyForecast = new ArrayList<V1dailycodeDailyForecast>();
        }
        this.dailyForecast.add(dailyForecastItem);
        return this;
    }

    /**
     * Get dailyForecast
     *
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
        DailyWeather dailyWeather = (DailyWeather) o;
        return Objects.equals(this.location, dailyWeather.location) && Objects.equals(this.dailyForecast,
                                                                                      dailyWeather.dailyForecast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, dailyForecast);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DailyWeather {\n");

        sb.append("    location: ").append(toIndentedString(location)).append("\n");
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
