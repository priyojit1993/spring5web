package guru.springframework.spring5web.bootstrap;

import guru.springframework.spring5web.model.Author;
import guru.springframework.spring5web.model.Book;
import guru.springframework.spring5web.model.Publisher;
import guru.springframework.spring5web.repositories.AuthorRepository;
import guru.springframework.spring5web.repositories.BookRepository;
import guru.springframework.spring5web.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    AuthorRepository authorRepository;

    BookRepository bookRepository;

    PublisherRepository publisherRepository;


    //constructor injection
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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


        Publisher publisher1 = new Publisher("11 xyz Street", "Cleveland", "ohio", "");
        publisherRepository.save(publisher1);


        System.out.println(publisherRepository.count());
        System.out.println(authorRepository.count());
        System.out.println(bookRepository.count());


    }
}
