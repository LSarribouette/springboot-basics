package fr.lsarribouette.springbootbasics.service;

import fr.lsarribouette.springbootbasics.model.Movie;
import fr.lsarribouette.springbootbasics.model.Genre;
import fr.lsarribouette.springbootbasics.model.Person;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    public abstract List<Movie> getAllMovies();

    public abstract Optional<Movie> getMovieById(long id);

    public abstract List<Genre> getAllGenres();

    public abstract List<Person> getAllPeople();

    public abstract Genre getGenreById(long id);

    public abstract Person getPeopleById(long id);

    public abstract void saveMovie(Movie movie);

    public abstract List<Person> getPeopleOrderedByName();
}
