package fr.lsarribouette.springbootbasics.service;

import fr.lsarribouette.springbootbasics.model.Genre;
import fr.lsarribouette.springbootbasics.model.Movie;
import fr.lsarribouette.springbootbasics.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceMock implements MovieService {
    private List<Movie> listMovies;
    private List<Genre> listGenres;
    private List<Person> listPeople;
    private static final String[] GENRES = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
            "Drame" };

    // dans un mock, on donne des donnees-bouchon dans le constructeur vide
    public MovieServiceMock() {

        // je recupere les listes de genres et personnes
        listGenres = initializeListGenres();
        listPeople = initializeListPeople();

        // un conteneur peut etre vide mais pas nul
        listMovies = new ArrayList<>();

        // 3 films
        // (!) List.of() cree des listes immuables
        Movie jurassicPark = new Movie(1, "Jurassic Park", 1993, 128,
                "Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.",
                listPeople.get(0), List.of(listPeople.get(2), listPeople.get(3)), listGenres.get(1));
        Movie theFly = new Movie(2, "The Fly", 1986, 95,
                "Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.",
                listPeople.get(1), List.of(listPeople.get(3), listPeople.get(4)), listGenres.get(1));
        Movie theBFG = new Movie(3, "The BFG", 2016, 117,
                "Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.",
                listPeople.get(0), List.of(listPeople.get(5), listPeople.get(6)), listGenres.get(4));
        listMovies.add(jurassicPark);
        listMovies.add(theFly);
        listMovies.add(theBFG);
    }

    @Override
    public List<Movie> getAllMovies() {
        return listMovies;
    }

//    @Override
//    public Movie getMovieById(long id) {
//        Movie found = null;
//        for (Movie movie : listMovies) {
//            if (movie.getId() == id) {
//                found = movie;
//                break;
//            }
//        }
//        return found;
//    }

    /**
     * Méthode qui renvoie un Optional de Movie dont l'identifiant correspond au paramètre.
     * @param id
     * @return optMovie
     */
    @Override
    public Optional<Movie> getMovieById(long id) {
        Optional<Movie> optMovie = Optional.empty();
        for (Movie movie : listMovies) {
            if (movie.getId() == id) {
                optMovie = Optional.of(movie);
                break;
            }
        }
        return optMovie;
    }

    @Override
    public List<Genre> getAllGenres() {
        return listGenres;
    }

    @Override
    public List<Person> getAllPeople() {
        return listPeople;
    }

    @Override
    public Genre getGenreById(long id) {
        Genre found = null;
        for (Genre genre : listGenres) {
            if (genre.getId() == id) {
                found = genre;
                break;
            }
        }
        return found;
    }

    @Override
    public Person getPeopleById(long id) {
        Person found = null;
        for (Person person : listPeople) {
            if (person.getId() == id) {
                found = person;
                break;
            }
        }
        return found;
    }

    @Override
    public void saveMovie(Movie movie) {
        // ici les verifications metier
        listMovies.add(movie);
    }

    @Override
    public List<Person> getPeopleOrderedByName() {
        List<Person> listPeopleOrdered = listPeople;
        listPeopleOrdered = listPeopleOrdered
			    .stream()
                .sorted((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()))
                .collect(Collectors.toList());
        return listPeopleOrdered;
    }
    
    private List<Genre> initializeListGenres() {
        listGenres = new ArrayList<>();
        for (int i=0; i < GENRES.length; i++) {
            listGenres.add(new Genre(i+1, GENRES[i]));
        }
        return listGenres;
    }

    private List<Person> initializeListPeople() {
        listPeople = new ArrayList<>();

        // 2 realisateurs
        Person stevenSpielberg = new Person(1, "Spielberg", "Steven");
        Person davidCronenberg = new Person(2, "Cronenberg", "David");
        listPeople.add(stevenSpielberg);
        listPeople.add(davidCronenberg);

        // 5 acteurs
        Person richardAttenborough = new Person(3, "Attenborough", "Richard");
        Person jeffGoldblum = new Person(4, "Goldblum", "Jeff");
        Person geenaDavis = new Person(5, "Davis", "Geena");
        Person markRylance = new Person(6, "Rylance", "Mark");
        Person rubyBarnhill = new Person(7, "Barnhill", "Ruby");
        listPeople.add(richardAttenborough);
        listPeople.add(jeffGoldblum);
        listPeople.add(geenaDavis);
        listPeople.add(markRylance);
        listPeople.add(rubyBarnhill);

        return listPeople;
    }
}
