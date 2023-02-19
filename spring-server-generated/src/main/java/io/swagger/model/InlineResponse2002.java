package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InlineResponse2002
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-19T13:27:40.311592936Z[GMT]")


public class InlineResponse2002 {
    @JsonProperty("location")
    private String location = null;

    @JsonProperty("hourly_forecast")
    @Valid
    private List<V1hourlycodeHourlyForecast> hourlyForecast = null;

    public InlineResponse2002 location(String location) {
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

    public InlineResponse2002 hourlyForecast(List<V1hourlycodeHourlyForecast> hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
        return this;
    }

    public InlineResponse2002 addHourlyForecastItem(V1hourlycodeHourlyForecast hourlyForecastItem) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
        return Objects.equals(this.location, inlineResponse2002.location) && Objects.equals(this.hourlyForecast,
                                                                                            inlineResponse2002.hourlyForecast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, hourlyForecast);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse2002 {\n");

        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    hourlyForecast: ").append(toIndentedString(hourlyForecast)).append("\n");
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
