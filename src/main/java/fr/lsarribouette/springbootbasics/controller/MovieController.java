package fr.lsarribouette.springbootbasics.controller;

import fr.lsarribouette.springbootbasics.model.Movie;
import fr.lsarribouette.springbootbasics.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    private MovieService movieService;

    @Autowired // optionnel en Spring Boot
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String goHome() {
        return "home";
    }

    @GetMapping("/movies")
    public String goListMovies(Model model) {
        model.addAttribute("list", movieService.getAllMovies());
        return "movies";
    }

    @GetMapping("/detail/{id}")
    public String goDetailMovie(
            @PathVariable("id") long id,
            Model model
            ) {
        // attention, il faudrait verifier que l'optional a un contenu...
        model.addAttribute("mymovie", movieService.getMovieById(id).get());
        return "detail-movie";
    }

    public List<Movie> showAllMovies() {
        return movieService.getAllMovies();
    }

    public Optional<Movie> findMovie(long id) {
        return movieService.getMovieById(id);
    }
}
