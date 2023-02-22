package com.skyapi.weatherforecast.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "locations")
@Data
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
}
