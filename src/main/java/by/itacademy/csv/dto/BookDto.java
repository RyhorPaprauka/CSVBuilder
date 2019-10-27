package by.itacademy.csv.dto;

import by.itacademy.csv.enam.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDto {

    private String name;
    private Integer publicationYear;
    private String authorName;
    private Genre genre;
}
