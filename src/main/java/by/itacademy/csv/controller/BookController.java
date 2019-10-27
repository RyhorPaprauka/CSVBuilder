package by.itacademy.csv.controller;

import by.itacademy.csv.filter.BookFilter;
import by.itacademy.csv.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private final BookService bookService;

    @PostMapping
    @RequestMapping(value = "/csv", produces = "text/csv")
    public ResponseEntity<byte[]> getCSVFile(@RequestBody @Valid BookFilter filter) {
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=books.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(bookService.getBookData(filter).toByteArray());
    }
}
