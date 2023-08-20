package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieHashMap = new HashMap<>();
    HashMap<String,Director> directorHashMap = new HashMap<>();
//    HashMap<Director, Movie> movieDirectorHashMap = new HashMap<>();
    HashMap<String,List<Movie>> movieDirectorHashMap = new HashMap<>();


    public void addMovie(Movie movie) {
        movieHashMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directorHashMap.put(director.getName(), director);
    }


    public String addMovieDirectorPair(String movieName, String directorName) {
        Movie movie = movieHashMap.get(movieName);
        Director director = directorHashMap.get(directorName);

        if (movie == null || director == null) {
            return "pairing unsuccessful";
        }

        if (movieDirectorHashMap.containsKey(director.getName())) {
            movieDirectorHashMap.get(director.getName()).add(movie);
        }
        else {
            List<Movie> list = new ArrayList<>();
            list.add(movie);
            movieDirectorHashMap.put(director.getName(),list);
        }

        return "pairing successful";
    }

    public Movie getMovieByName(String movieName) {
        return movieHashMap.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return directorHashMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        if (!movieDirectorHashMap.containsKey(directorName)) {
            return null;
        }

        List<Movie> list = movieDirectorHashMap.get(directorName);
        List<String> res = new ArrayList<>();
        for (Movie mov: list) {
            res.add(mov.getName());
        }

        return res;

    }


    public List<String> findAllMovies() {
        List<String> res = new ArrayList<>();

        for (Map.Entry<String,Movie> entry: movieHashMap.entrySet()) {
            res.add(entry.getKey());
        }

        return res;
    }

    public void deleteDirectorByName(String directorName) {
        if (directorHashMap.containsKey(directorName)) {
            directorHashMap.remove(directorName);
        }

        List<Movie> list = movieDirectorHashMap.get(directorName);
        for (Movie mov: list) {
            movieHashMap.remove(mov.getName());
        }

        movieDirectorHashMap.remove(directorName);
    }

    public void deleteAllDirectors() {
        directorHashMap.clear();

        for (Map.Entry<String,List<Movie>> entry: movieDirectorHashMap.entrySet()) {
            String director = entry.getKey();
            List<Movie> toBeDel = entry.getValue();
            for (Movie mov: toBeDel) {
                movieHashMap.remove(mov.getName());
            }
        }

        movieDirectorHashMap.clear();
    }

//    public List<String> findAllDirectors() {
//        List<String> res = new ArrayList<>();
//
//        for (Map.Entry<String,Director> entry: directorHashMap.entrySet()) {
//            res.add(entry.getKey());
//        }
//
//        return res;
//    }
}
