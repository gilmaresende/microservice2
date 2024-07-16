package br.com.gir.book_service.reppositories;

import br.com.gir.book_service.modal.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
