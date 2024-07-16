package br.com.gir.book_service.controller;

import br.com.gir.book_service.modal.Book;
import br.com.gir.book_service.reppositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {


        Optional<Book> opBook = bookRepository.findById(id);
        if (opBook.isEmpty()) throw new RuntimeException("Book not fond");

        String port = environment.getProperty("local.server.port");

        Book book = opBook.get();
        book.setEnviroment(port);

        return book;
    }
}
