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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    @Column(name = "location_code", length = 12, nullable = false, unique = true)
    @JsonProperty(value = "location_code")
    @Id
    @NotBlank
    private String code;

    @Column(name = "city_name", length = 128, nullable = false)
    @JsonProperty(value = "city_name")
    @NotBlank
    private String cityName;

    @Column(name = "region_name", length = 128)
    @JsonProperty(value = "region_name")
    @NotBlank
    private String regionName;

    @Column(name = "country_name", length = 64, nullable = false)
    @JsonProperty(value = "country_name")
    @NotBlank
    private String countryName;

    @Column(name = "country_code", length = 2, nullable = false)
    @JsonProperty(value = "country_code")
    @NotBlank
    private String countryCode;

    @JsonProperty(value = "enabled")
    private boolean enabled;

    @JsonIgnore
    private boolean trashed;


}
