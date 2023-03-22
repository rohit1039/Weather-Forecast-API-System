package com.skyapi.weatherforecast.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Location {

    @Column(name = "code", length = 12, nullable = false, unique = true)
    @JsonProperty(value = "code")
    @Id
    @Length(min = 3, max = 12, message = "Location code must have 3-12 characters")
    @NotNull(message = "Location code cannot be null")
    private String code;

    @Column(name = "city_name", length = 128, nullable = false)
    @JsonProperty(value = "city_name")
    @Length(min = 3, max = 128, message = "City name must have 3-128 characters")
    @NotNull(message = "City name cannot be null")
    private String cityName;

    @Column(name = "region_name", length = 128)
    @JsonProperty(value = "region_name")
    @Length(min = 3, max = 128, message = "Region name must have 3-128 characters")
    @NotNull(message = "Region name cannot be null")
    private String regionName;

    @Column(name = "country_name", length = 64, nullable = false)
    @JsonProperty(value = "country_name")
    @Length(min = 3, max = 64, message = "Country name must have 3-64 characters")
    @NotNull(message = "Country name cannot be null")
    private String countryName;

    @Column(name = "country_code", length = 2, nullable = false)
    @JsonProperty(value = "country_code")
    @Length(min = 2, max = 2, message = "Country code must have 2 characters")
    @NotNull(message = "Country code cannot be null")
    private String countryCode;

    @JsonProperty(value = "enabled")
    private boolean enabled;

    @JsonIgnore
    private boolean trashed;

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private RealtimeWeather realtimeWeather;

    public Location(String cityName, String regionName, String countryName, String countryCode) {
        this.cityName = cityName;
        this.regionName = regionName;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Location{" + "code='" + code + '\'' + ", cityName='" + cityName + '\'' + ", regionName='" + regionName + '\'' + ", countryName='" + countryName + '\'' + ", countryCode='" + countryCode + '\'' + ", enabled=" + enabled + ", trashed=" + trashed + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Location location = (Location) o;

        if (enabled != location.enabled) {
            return false;
        }
        if (trashed != location.trashed) {
            return false;
        }
        if (!Objects.equals(code, location.code)) {
            return false;
        }
        if (!Objects.equals(cityName, location.cityName)) {
            return false;
        }
        if (!Objects.equals(regionName, location.regionName)) {
            return false;
        }
        if (!Objects.equals(countryName, location.countryName)) {
            return false;
        }
        if (!Objects.equals(countryCode, location.countryCode)) {
            return false;
        }
        return Objects.equals(realtimeWeather, location.realtimeWeather);
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (trashed ? 1 : 0);
        result = 31 * result + (realtimeWeather != null ? realtimeWeather.hashCode() : 0);
        return result;
    }
}
