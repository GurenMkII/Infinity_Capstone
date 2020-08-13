package com.tts.stream.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieResponse {
    private List<Movie> results;
}