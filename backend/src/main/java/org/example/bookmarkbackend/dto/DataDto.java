package org.example.bookmarkbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DataDto(
        @JsonProperty("id") String id,
        @JsonProperty("params") List<Params> params
){}



