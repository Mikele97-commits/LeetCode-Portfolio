package org.example.bookmarkbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Params(
        @JsonProperty("name") String name,
        @JsonProperty("type") String type,
        @JsonProperty("value") String value
){}


