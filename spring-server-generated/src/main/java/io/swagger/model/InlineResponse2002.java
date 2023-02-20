package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.V1dailycodeDailyForecast;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse2002
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T06:40:29.743300367Z[GMT]")


public class InlineResponse2002   {
  @JsonProperty("location")
  private String location = null;

  @JsonProperty("daily_forecast")
  @Valid
  private List<V1dailycodeDailyForecast> dailyForecast = null;

  public InlineResponse2002 location(String location) {
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

  public InlineResponse2002 dailyForecast(List<V1dailycodeDailyForecast> dailyForecast) {
    this.dailyForecast = dailyForecast;
    return this;
  }

  public InlineResponse2002 addDailyForecastItem(V1dailycodeDailyForecast dailyForecastItem) {
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
    InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
    return Objects.equals(this.location, inlineResponse2002.location) &&
        Objects.equals(this.dailyForecast, inlineResponse2002.dailyForecast);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, dailyForecast);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002 {\n");
    
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
