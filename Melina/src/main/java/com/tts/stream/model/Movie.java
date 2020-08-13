package com.tts.stream.model;

import lombok.Data;

@Data
public class Movie {
    private String Title;
    private String vote_average;
    private String overview;
    private String release_date;
    private String poster_path;
    private String id;

}