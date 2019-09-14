package by.itacademy.csv.enam;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre {
    CLASSIC("Classic"),
    COMEDY("Comedy"),
    FANTASY("Fantasy"),
    THRILLER("Thriller"),
    RELIGIOUS("Religious");

    private String name;
}
