package fr.lsarribouette.springbootbasics;

import fr.lsarribouette.springbootbasics.controller.MovieController;
import fr.lsarribouette.springbootbasics.model.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        MovieController movieBean = context.getBean("movieBean", MovieController.class);

        // Affichage du premier film

//        System.out.println("Le premier film est : ");
//        Movie firstMovie = movieBean.findMovie(1);
//        System.out.println(firstMovie);
//        System.out.println("Le premier film est : ");

        // -- avec un film qui existe
        Optional<Movie> optFirstMovie = movieBean.findMovie(1);
        if (optFirstMovie.isPresent()) {
            System.out.println("Film 1 trouvé : " + optFirstMovie.get().getTitle());
        } else {
            System.out.println("Film 1 non trouvé");
        }

        // -- avec un film qui n'existe pas
        Optional<Movie> optMovie100 = movieBean.findMovie(100);
        if (optMovie100.isPresent()) {
            System.out.println("Film 100 trouvé : " + optMovie100.get().getTitle());
        } else {
            System.out.println("Film 100 non trouvé");
        }

        // Affichage de la liste des films
        System.out.println("\nTous les films : ");
        List<Movie> lstMovies = movieBean.showAllMovies();
        for (Movie movie : lstMovies) {
            System.out.println(" - " + movie.getTitle());
        }

    }
}
