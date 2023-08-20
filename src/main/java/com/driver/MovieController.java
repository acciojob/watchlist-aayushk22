package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    //adding movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        String response = movieService.addMovie(movie);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String response = movieService.addDirector(director);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("mn") String movieName, @RequestParam("dn") String directorName) {
        String response = movieService.addMovieDirectorPair(movieName,directorName);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName) {
        Movie movie = movieService.getMovieByName(movieName);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName) {
        Director director = movieService.getDirectorByName(directorName);
        return ResponseEntity.ok(director);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>getMoviesByDirectorName(@PathVariable("director") String directorName) {
        List<String> result = movieService.getMoviesByDirectorName(directorName);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>>findAllMovies() {
        List<String> result = movieService.findAllMovies();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-all-directors")
    public ResponseEntity<List<String>>findAllDirectors() {
        List<String> result = movieService.findAllDirectors();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("dn") String directorName){
        String response = movieService.deleteDirectorByName(directorName);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(@RequestParam("dn") String directorName) {
        String response = movieService.deleteAllDirectors(directorName);
        return ResponseEntity.ok(response);
    }

}
