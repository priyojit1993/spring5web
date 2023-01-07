package guru.springframework.spring5web.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "address_line1")
    private String addressLine1;
    private String city;
    private String State;
    private String zipCode;
    @OneToMany
    // tells hibernate to add a column named publisher_id as foreign key in the book table to track the one to many relationship.
    @JoinColumn(name = "publisher_id")
    private Set<Book> books;


    public Publisher(String addressLine1, String city, String state, String zipCode) {
        this.addressLine1 = addressLine1;
        this.city = city;
        State = state;
        this.zipCode = zipCode;
        books = new HashSet<Book>();
    }

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id.equals(publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", State='" + State + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
