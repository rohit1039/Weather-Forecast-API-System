package com.skyapi.weatherforecast.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    @Column(name = "code", length = 12, nullable = false, unique = true)
    @JsonProperty(value = "code")
    @Id
    @NotBlank(message = "Location code is required")
    private String code;

    @Column(name = "city_name", length = 128, nullable = false)
    @JsonProperty(value = "city_name")
    @NotBlank(message = "cityName is required")
    private String cityName;

    @Column(name = "region_name", length = 128)
    @JsonProperty(value = "region_name")
    private String regionName;

    @Column(name = "country_name", length = 64, nullable = false)
    @JsonProperty(value = "country_name")
    @NotBlank(message = "countryName is required")
    private String countryName;

    @Column(name = "country_code", length = 2, nullable = false)
    @JsonProperty(value = "country_code")
    @NotBlank(message = "countryCode is required")
    private String countryCode;

    @JsonProperty(value = "enabled")
    private boolean enabled;

    @JsonIgnore
    private boolean trashed;
}
