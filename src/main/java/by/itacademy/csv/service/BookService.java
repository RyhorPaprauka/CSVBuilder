package by.itacademy.csv.service;

import by.itacademy.csv.enam.CSVTitle;
import by.itacademy.csv.filter.BookFilter;
import by.itacademy.csv.filter.QueryBuilder;
import by.itacademy.csv.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private final BookRepository bookRepository;
    private final QueryBuilder queryBuilder;


    public ByteArrayOutputStream getBookData(BookFilter filter) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        OutputStreamWriter appendable = new OutputStreamWriter(stream);
        try {
            CSVPrinter printer = new CSVPrinter(appendable, CSVFormat.DEFAULT
                    .withHeader(CSVTitle.class));
            fillCSV(printer, queryBuilder.createSelectBookQuery(filter));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stream;
    }

    private void fillCSV(CSVPrinter printer, String query) {
        bookRepository.findAll(query).forEach(b -> {
            try {
                printer.printRecord(
                        b.getName(),
                        b.getPublicationYear(),
                        b.getAuthorName(),
                        b.getGenre().getName());
                printer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
