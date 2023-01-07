package guru.springframework.spring5web.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors") // many to many relationship mapped by authors defined in book entity
    private Set<Book> books;


    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        books = new HashSet<Book>();
    }

    /*
     * JPA needs Entities or POJO's to have default constructor.
     * */

    public Author() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }
    /*
     * In order to prevent leakage from entity object we have to override the equals and hashcode method in our entity classes,because standard equals and hashcode method provided by java are not enough to prevent the leakage.
     * we have to override the equals and hashcode method based on the id property of the entity object,so that hibernated considers two entity objects(or records of relation) to be equal if they have same value for their id column.
     *
     *
     * */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                // removed as it will lead to circular refference", books=" + books +
                '}';
    }
}
