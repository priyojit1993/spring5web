package guru.springframework.spring5web.bootstrap;

import guru.springframework.spring5web.model.Author;
import guru.springframework.spring5web.model.Book;
import guru.springframework.spring5web.repositories.AuthorRepository;
import guru.springframework.spring5web.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    AuthorRepository authorRepository;

    BookRepository bookRepository;


    //Constructor injection
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jack = new Author("Jack", "Jones");
        Book java_design_pattern = new Book("Java Design pattern", "112344");
        jack.getBooks().add(java_design_pattern);
        java_design_pattern.getAuthors().add(jack);
        authorRepository.save(jack);
        bookRepository.save(java_design_pattern);

        Author rod = new Author("Rodh", "Jhonson");
        Book spring = new Book("spring 1", "1233455");
        rod.getBooks().add(spring);
        spring.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(spring);


        System.out.println(authorRepository.count());
        System.out.println(bookRepository.count());


    }
}
