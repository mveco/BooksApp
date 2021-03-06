package finki.ukim.mk.wpproekt.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String title;
    private Float avg_rating;
    private String isbn;
    private String isbn13;
    private String lang_code;
    private Integer num_pages;
    private Integer ratings_count;

    @ManyToOne
    @JoinColumn(name="publisherID")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "Book_Author",
            joinColumns = {@JoinColumn(name = "bookID")},
            inverseJoinColumns = { @JoinColumn(name = "authorID") })
    private List<Author> authors;

    public Book(String title, Float avg_rating, String isbn, String isbn13, String lang_code, Integer num_pages,
                Integer ratings_count, Publisher publisher, List<Author> authors) {
        this.title = title;
        this.avg_rating = avg_rating;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.lang_code = lang_code;
        this.num_pages = num_pages;
        this.ratings_count = ratings_count;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Book() {

    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
