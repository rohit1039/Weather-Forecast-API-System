package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Location
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T06:40:29.743300367Z[GMT]")


public class Location   {
  @JsonProperty("location_code")
  private String locationCode = null;

  @JsonProperty("city_name")
  private String cityName = null;

  @JsonProperty("region_name")
  private String regionName = null;

  @JsonProperty("country_code")
  private String countryCode = null;

  @JsonProperty("country_name")
  private String countryName = null;

  @JsonProperty("enabled")
  private Boolean enabled = null;

  public Location locationCode(String locationCode) {
    this.locationCode = locationCode;
    return this;
  }

  /**
   * unique code of a location
   * @return locationCode
   **/
  @Schema(example = "LACA_US", description = "unique code of a location")
  
    public String getLocationCode() {
    return locationCode;
  }

  public void setLocationCode(String locationCode) {
    this.locationCode = locationCode;
  }

  public Location cityName(String cityName) {
    this.cityName = cityName;
    return this;
  }

  /**
   * name of the city
   * @return cityName
   **/
  @Schema(example = "Los Angeles", description = "name of the city")
  
    public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public Location regionName(String regionName) {
    this.regionName = regionName;
    return this;
  }

  /**
   * name of the region, state or province
   * @return regionName
   **/
  @Schema(example = "California", description = "name of the region, state or province")
  
    public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }

  public Location countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * 2 characters representing country code based on ISO 3166 standard
   * @return countryCode
   **/
  @Schema(example = "US", description = "2 characters representing country code based on ISO 3166 standard")
  
    public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Location countryName(String countryName) {
    this.countryName = countryName;
    return this;
  }

  /**
   * name of the country based on ISO 3166 standard
   * @return countryName
   **/
  @Schema(example = "United States of America", description = "name of the country based on ISO 3166 standard")
  
    public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public Location enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * whether the location enabled (true) or disabled (false)
   * @return enabled
   **/
  @Schema(example = "true", description = "whether the location enabled (true) or disabled (false)")
  
    public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.locationCode, location.locationCode) &&
        Objects.equals(this.cityName, location.cityName) &&
        Objects.equals(this.regionName, location.regionName) &&
        Objects.equals(this.countryCode, location.countryCode) &&
        Objects.equals(this.countryName, location.countryName) &&
        Objects.equals(this.enabled, location.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locationCode, cityName, regionName, countryCode, countryName, enabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    locationCode: ").append(toIndentedString(locationCode)).append("\n");
    sb.append("    cityName: ").append(toIndentedString(cityName)).append("\n");
    sb.append("    regionName: ").append(toIndentedString(regionName)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    countryName: ").append(toIndentedString(countryName)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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
