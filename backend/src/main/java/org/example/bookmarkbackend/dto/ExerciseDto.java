package org.example.bookmarkbackend.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ExerciseDto(
        @JsonProperty("id")  String id,
        @JsonProperty("title")  String title,
        @JsonProperty("category")  String category,
        @JsonProperty("difficulty")  String difficulty,
        @JsonProperty("link")  String link,
        String description,
        String code,
        @JsonProperty("inputs") List<InputParamDto> inputs

        ) {}

