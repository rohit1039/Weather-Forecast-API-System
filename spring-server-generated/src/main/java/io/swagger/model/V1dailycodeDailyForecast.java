package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * V1dailycodeDailyForecast
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T06:40:29.743300367Z[GMT]")


public class V1dailycodeDailyForecast   {
  @JsonProperty("day_of_month")
  private BigDecimal dayOfMonth = null;

  @JsonProperty("month")
  private BigDecimal month = null;

  @JsonProperty("min_temp")
  private BigDecimal minTemp = null;

  @JsonProperty("max_temp")
  private BigDecimal maxTemp = null;

  @JsonProperty("precipitation")
  private BigDecimal precipitation = null;

  @JsonProperty("status")
  private String status = null;

  public V1dailycodeDailyForecast dayOfMonth(BigDecimal dayOfMonth) {
    this.dayOfMonth = dayOfMonth;
    return this;
  }

  /**
   * the forecasted day
   * @return dayOfMonth
   **/
  @Schema(example = "8", description = "the forecasted day")
  
    @Valid
    public BigDecimal getDayOfMonth() {
    return dayOfMonth;
  }

  public void setDayOfMonth(BigDecimal dayOfMonth) {
    this.dayOfMonth = dayOfMonth;
  }

  public V1dailycodeDailyForecast month(BigDecimal month) {
    this.month = month;
    return this;
  }

  /**
   * the forecasted month (1-12)
   * @return month
   **/
  @Schema(example = "8", description = "the forecasted month (1-12)")
  
    @Valid
    public BigDecimal getMonth() {
    return month;
  }

  public void setMonth(BigDecimal month) {
    this.month = month;
  }

  public V1dailycodeDailyForecast minTemp(BigDecimal minTemp) {
    this.minTemp = minTemp;
    return this;
  }

  /**
   * the forecasted minimum temperature (default in Celsius degree)
   * @return minTemp
   **/
  @Schema(example = "12", description = "the forecasted minimum temperature (default in Celsius degree)")
  
    @Valid
    public BigDecimal getMinTemp() {
    return minTemp;
  }

  public void setMinTemp(BigDecimal minTemp) {
    this.minTemp = minTemp;
  }

  public V1dailycodeDailyForecast maxTemp(BigDecimal maxTemp) {
    this.maxTemp = maxTemp;
    return this;
  }

  /**
   * the forecasted maximum temperature (default in Celsius degree)
   * @return maxTemp
   **/
  @Schema(example = "12", description = "the forecasted maximum temperature (default in Celsius degree)")
  
    @Valid
    public BigDecimal getMaxTemp() {
    return maxTemp;
  }

  public void setMaxTemp(BigDecimal maxTemp) {
    this.maxTemp = maxTemp;
  }

  public V1dailycodeDailyForecast precipitation(BigDecimal precipitation) {
    this.precipitation = precipitation;
    return this;
  }

  /**
   * percentage chance of rain
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

  public V1dailycodeDailyForecast status(String status) {
    this.status = status;
    return this;
  }

  /**
   * current weather status
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
    V1dailycodeDailyForecast v1dailycodeDailyForecast = (V1dailycodeDailyForecast) o;
    return Objects.equals(this.dayOfMonth, v1dailycodeDailyForecast.dayOfMonth) &&
        Objects.equals(this.month, v1dailycodeDailyForecast.month) &&
        Objects.equals(this.minTemp, v1dailycodeDailyForecast.minTemp) &&
        Objects.equals(this.maxTemp, v1dailycodeDailyForecast.maxTemp) &&
        Objects.equals(this.precipitation, v1dailycodeDailyForecast.precipitation) &&
        Objects.equals(this.status, v1dailycodeDailyForecast.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dayOfMonth, month, minTemp, maxTemp, precipitation, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1dailycodeDailyForecast {\n");
    
    sb.append("    dayOfMonth: ").append(toIndentedString(dayOfMonth)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    minTemp: ").append(toIndentedString(minTemp)).append("\n");
    sb.append("    maxTemp: ").append(toIndentedString(maxTemp)).append("\n");
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
