package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return "movie added successfully";
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        String res = movieRepository.addMovieDirectorPair(movieName,directorName);
        return res;
    }


    public Movie getMovieByName(String movieName) {
        Movie mov = movieRepository.getMovieByName(movieName);
        return mov;
    }


    public Director getDirectorByName(String directorName) {
        Director dir = movieRepository.getDirectorByName(directorName);
        return dir;
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        List<String> res = movieRepository.getMoviesByDirectorName(directorName);
        return res;
    }

    public List<String> findAllMovies() {
        List<String> res = movieRepository.findAllMovies();
        return res;
    }

    public String deleteDirectorByName(String directorName) {
        movieRepository.deleteDirectorByName(directorName);
        return "Director and his movies deleted successfully";
    }

    public String deleteAllDirectors(String directorName) {
        movieRepository.deleteAllDirectors(directorName);
        return "All directors deleted successfully";
    }

    public List<String> findAllDirectors() {
        List<String> res = movieRepository.findAllDirectors();
        return res;
    }
}
