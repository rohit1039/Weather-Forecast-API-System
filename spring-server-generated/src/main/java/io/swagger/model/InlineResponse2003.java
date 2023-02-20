package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InlineResponse2003
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T06:40:29.743300367Z[GMT]")


public class InlineResponse2003 {
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

    public InlineResponse2003 location(String location) {
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

    public InlineResponse2003 realtime(V1fullcodeRealtime realtime) {
        this.realtime = realtime;
        return this;
    }

    /**
     * Get realtime
     *
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

    public InlineResponse2003 hourlyForecast(List<V1hourlycodeHourlyForecast> hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
        return this;
    }

    public InlineResponse2003 addHourlyForecastItem(V1hourlycodeHourlyForecast hourlyForecastItem) {
        if (this.hourlyForecast == null) {
            this.hourlyForecast = new ArrayList<V1hourlycodeHourlyForecast>();
        }
        this.hourlyForecast.add(hourlyForecastItem);
        return this;
    }

    /**
     * Get hourlyForecast
     *
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

    public InlineResponse2003 dailyForecast(List<V1dailycodeDailyForecast> dailyForecast) {
        this.dailyForecast = dailyForecast;
        return this;
    }

    public InlineResponse2003 addDailyForecastItem(V1dailycodeDailyForecast dailyForecastItem) {
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
        InlineResponse2003 inlineResponse2003 = (InlineResponse2003) o;
        return Objects.equals(this.location, inlineResponse2003.location) && Objects.equals(this.realtime,
                                                                                            inlineResponse2003.realtime) && Objects.equals(
                this.hourlyForecast, inlineResponse2003.hourlyForecast) && Objects.equals(this.dailyForecast,
                                                                                          inlineResponse2003.dailyForecast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, realtime, hourlyForecast, dailyForecast);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse2003 {\n");

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
