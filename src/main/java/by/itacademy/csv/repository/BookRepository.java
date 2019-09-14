package by.itacademy.csv.repository;

import by.itacademy.csv.dto.BookDto;
import by.itacademy.csv.enam.Genre;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<BookDto> findAll(String sql) {
        return jdbcTemplate.query(sql,
                (rs, rowNum) ->
                        new BookDto(rs.getString("book.name"),
                                rs.getTimestamp("book.creation_year").toLocalDateTime().getYear(),
                                rs.getString("author.name"),
                                Genre.valueOf(rs.getString("genre.name"))));
    }
}
