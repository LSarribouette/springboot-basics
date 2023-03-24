package fr.lsarribouette.springbootbasics.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private long id;
    private String title;
    private int year;
    private int duration;
    private String synopsis;

    // relations unidirectionnelles
    private Person director;
    private List<Person> actors;
    private Genre genre;

    public Movie() {
        // un conteneur peut etre vide mais pas nul, on passe par le setter
        setActors(null);
    }

    public Movie(long id, String title, int year, int duration, String synopsis, Person director, List<Person> actors, Genre genre) {
        this();
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.director = director;
        setActors(actors);
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        if (actors == null) {
            this.actors = new ArrayList<>();
        } else {
            this.actors = actors;
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", synopsis='" + synopsis + '\'' +
                ", director=" + director +
                ", actors=" + actors +
                ", genre=" + genre +
                '}';
    }
}
