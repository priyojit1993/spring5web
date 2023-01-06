package guru.springframework.spring5web.repositories;

import guru.springframework.spring5web.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
