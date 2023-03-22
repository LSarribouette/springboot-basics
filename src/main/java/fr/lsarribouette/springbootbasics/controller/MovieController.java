package fr.lsarribouette.springbootbasics.controller;

import fr.lsarribouette.springbootbasics.model.Movie;
import fr.lsarribouette.springbootbasics.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller("movieBean")
public class MovieController {

    private MovieService movieService;

    @Autowired // optionnel
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> showAllMovies() {
        return movieService.getAllMovies();
    }

    public Optional<Movie> findMovie(long id) {
        return movieService.getMovieById(id);
    }
}
