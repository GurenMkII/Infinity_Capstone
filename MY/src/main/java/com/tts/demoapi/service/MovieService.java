package com.tts.demoapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.tts.demoapi.model.Movie;
import com.tts.demoapi.model.MovieRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MovieService {

    @Value("${test_omdb_api}")
    public String movieUrl;

    

    public List<Movie> getMovies(MovieRequest request){
        RestTemplate restTemplate = new RestTemplate();
        Movie[] movies = restTemplate.getForObject(movieUrl, Movie[].class);
        List<Movie> allMovies = Arrays.asList(movies);
        return allMovies;
    }

    // private Location getCoordinates(String description) {
    //     description = description.replace(" ", "+");
    //     String url = geocodingUrl + description + "+GA&key=" + googleApiKey;
    //     RestTemplate restTemplate = new RestTemplate();
    //     GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
    //     return response.results.get(0).geometry.location;
    // }

    // private double getDistance(Location origin, Location destination){

    //     String url = distanceUrl + "origins=" + origin.lat + "," + origin.lng + "&destinations=" + destination.lat + "," + destination.lng + "&key=" + googleApiKey;
    //     RestTemplate restTemplate = new RestTemplate();
    //     DistanceResponse response = restTemplate.getForObject(url, DistanceResponse.class);
    //     return response.rows.get(0).elements.get(0).distance.value * 0.000621371;

    // }

    public List<Movie> getAllMovies(MovieRequest request){
        List<Movie> allMovies = this.getMovies();
        Location personLocation = this.getCoordinates(request.address + " " + request.city);
        List<Movie> someMovies = new ArrayList<>();

        for(Bus bus : allBuses){
            Location busLocation = new Location();
            busLocation.lat = bus.LATITUDE;
            busLocation.lng = bus.LONGITUDE;

            double latDistance = Double.parseDouble(busLocation.lat) - Double.parseDouble(personLocation.lat);
            double lngDistance = Double.parseDouble(busLocation.lng) - Double.parseDouble(personLocation.lng);

            if (Math.abs(latDistance) <= 0.02 && Math.abs(lngDistance) <= 0.02){
                double distance = getDistance(busLocation, personLocation);
                if (distance <= 1){
                    bus.distance = (double) Math.round(distance * 100) / 100;
                    nearbyBuses.add(bus);
                }
            }
        }

        Collections.sort(nearbyBuses, new BusComparator());
        return allMovies;

    }
    
}