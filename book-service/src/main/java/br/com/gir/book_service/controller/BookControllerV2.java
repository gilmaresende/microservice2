package br.com.gir.book_service.controller;

import br.com.gir.book_service.modal.Book;
import br.com.gir.book_service.propx.CambioProx;
import br.com.gir.book_service.reppositories.BookRepository;
import br.com.gir.book_service.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("book-service-v2")
public class BookControllerV2 {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProx cambioProx;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {


        Optional<Book> opBook = bookRepository.findById(id);
        if (opBook.isEmpty()) throw new RuntimeException("Book not fond");
        Book book = opBook.get();


        Cambio cambio = cambioProx.getCambio(book.getPrice(), "USD", currency);

        book.setPrice(cambio.getConversionValue());

        String port = environment.getProperty("local.server.port");

        book.setEnviroment(port + "-FEING");

        return book;
    }
}
