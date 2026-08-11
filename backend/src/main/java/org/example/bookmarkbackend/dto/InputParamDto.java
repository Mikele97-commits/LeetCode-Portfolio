package org.example.bookmarkbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InputParamDto(
        @JsonProperty("name") String name,
        @JsonProperty("label") String label,
        @JsonProperty("type") String type
) {}
