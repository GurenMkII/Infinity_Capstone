package com.tts.demoapi.controller;

import java.util.List;

import com.tts.demoapi.model.Movie;
import com.tts.demoapi.model.MovieRequest;
import com.tts.demoapi.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    @Autowired
    private MovieService apiService;

    @GetMapping("/movies")
    public String getMoviesPage(Model model){
        model.addAttribute("request", new MovieRequest());
        return "index";
    }

    @PostMapping("/movies")
    public String getAllMovies(MovieRequest request, Model model){
        List<Movie> movies = apiService.getMovies(request);
        model.addAttribute("movies", movies);
        model.addAttribute("request", request);
        return "index";
    }

}


