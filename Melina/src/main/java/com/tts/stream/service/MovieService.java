package com.tts.stream.service;

import com.tts.stream.model.Movie;
import com.tts.stream.model.MovieResponse;
import com.tts.stream.model.TVResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
    @Value("${api_key}")
    private String apiKey;

    public Movie id = new Movie();

    public MovieResponse getPopularMovies(int pageNumber) {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=en-US&page="
                + pageNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, MovieResponse.class);
    }

    public MovieResponse getTopRatedMovies(int pageNumber) {
        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=" + apiKey + "&language=en-US&page="
                + pageNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, MovieResponse.class);
    }

    public MovieResponse getUpcomingMovies(int pageNumber) {
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=" + apiKey + "&language=en-US&page="
                + pageNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, MovieResponse.class);
    }

    public MovieResponse getNowPlayingMovies(int pageNumber) {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + apiKey + "&language=en-US&page="
                + pageNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, MovieResponse.class);
    }

    // public MovieResponse getMovieImages(int pageNumber){
    // String url="https://image.tmdb.org/t/p/w500"+id.getPoster_path();
    // RestTemplate restTemplate=new RestTemplate();
    // return restTemplate.getForObject(url,MovieResponse.class);
    // }
    public TVResponse getPopularTVShows(int pageNumber) {
        String url = "https://api.themoviedb.org/3/tv/popular?api_key=" + apiKey + "&language=en-US&page=" + pageNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, TVResponse.class);
    }

    public TVResponse getTopRatedTVShows(int pageNumber) {
        String url = "https://api.themoviedb.org/3/tv/top_rated?api_key=" + apiKey + "&language=en-US&page="
                + pageNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, TVResponse.class);
    }
}