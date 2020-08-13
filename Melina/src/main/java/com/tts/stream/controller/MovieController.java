package com.tts.stream.controller;

import com.tts.stream.model.MovieResponse;
import com.tts.stream.model.TVResponse;
import com.tts.stream.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String getIndex(Model model) {
        MovieResponse movies=movieService.getPopularMovies(1);
        MovieResponse moviestr=movieService.getTopRatedMovies(1);
        MovieResponse moviesUpcoming=movieService.getUpcomingMovies(1);
        MovieResponse moviesNowPlaying=movieService.getNowPlayingMovies(1);
    //  MovieResponse moviesImages=movieService.getMovieImages(1);
        TVResponse popularTVshows=movieService.getPopularTVShows(1);
        TVResponse topRatedTVshows=movieService.getTopRatedTVShows(1);

        model.addAttribute("movies", movies.getResults());
        model.addAttribute("moviestr", moviestr.getResults());
        model.addAttribute("moviesUpcoming", moviesUpcoming.getResults());
        model.addAttribute("moviesNowPlaying", moviesNowPlaying.getResults());
        // model.addAttribute("moviesImages", moviesImages.getResults());
        model.addAttribute("popularTVShows", popularTVshows.getResults());
        model.addAttribute("topRatedTVShows", topRatedTVshows.getResults());
        
        return "index";
    }

   

    @PostMapping
    public String postIndex( Model model){
      
		return "index"; 
    }
}