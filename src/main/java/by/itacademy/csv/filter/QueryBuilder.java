package by.itacademy.csv.filter;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QueryBuilder {

    private static final String DEFAULT_BOOK_SELECT_QUERY = "select book.name,book.creation_year, author.name, genre.name from book "
            + "left join author on book.author_id = author.id "
            + "left join genre on book.genre_id = genre.id "
            + "where extract (year from book.creation_year) >= %s  "
            + "and extract (year from book.creation_year) <=%s";
    private static final String UPPER_AUTHOR_NAME = " upper (author.name) = '%s'";
    private static final String GENRE_NAME = " genre.name = '%s'";
    private static final String AND_BRACKETS = " and (%s)";

    public String createSelectBookQuery(BookFilter filter) {
        StringBuilder query = new StringBuilder(
                String.format(DEFAULT_BOOK_SELECT_QUERY, filter.getAfter(), filter.getBefore()));
        if (!filter.getAuthors().isEmpty()) {
            query.append(String.format(AND_BRACKETS,
                    filter.getAuthors().stream()
                            .map(author -> String.format(UPPER_AUTHOR_NAME, author.toUpperCase()))
                            .collect(Collectors.joining(" or"))));
        }
        if (!filter.getGenres().isEmpty()) {
            query.append(String.format(AND_BRACKETS,
                    filter.getGenres().stream()
                            .map(genre -> String.format(GENRE_NAME, genre))
                            .collect(Collectors.joining(" or"))));
        }
        return query.toString();
    }
}
