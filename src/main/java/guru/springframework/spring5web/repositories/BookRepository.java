package guru.springframework.spring5web.repositories;

import guru.springframework.spring5web.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
