package by.itacademy.csv.filter;

import by.itacademy.csv.enam.Genre;
import by.itacademy.csv.validator.NonEmptyObject;

import java.time.LocalDate;
import java.util.Set;

@NonEmptyObject
public class BookFilter {

    private Set<String> authors;
    private Set<Genre> genres;
    private Integer after;
    private Integer before;

    public BookFilter(Set<String> authors, Set<Genre> genres, Integer after, Integer before) {
        this.authors = authors;
        this.genres = genres;
        this.after = after;
        this.before = before;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public Integer getAfter() {
        return after == null ? 0 : after;
    }

    public Integer getBefore() {
        return before == null ? LocalDate.now().getYear() : before;
    }
}
