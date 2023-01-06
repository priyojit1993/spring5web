package guru.springframework.spring5web.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    @ManyToMany
    /*
     * @JoinTable annotation tells hibernate to create a new table that will hold the record of books and authors ,this table
     * is the join table ,name property defines the name of the new join table
     *      author_book
     *   ----------------------
     *    book_id
     *    author_id
     *
     * joinColumns property defines the column of the  current entity that will be mapped in the join table
     * inversejoinColumns property defines the column of the mapped entity that will be present in the join table
     *
     * @JoinColumn annotation is used to point to the specific column of the mapped entities.
     *
     * */
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
        authors = new HashSet<Author>();
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
