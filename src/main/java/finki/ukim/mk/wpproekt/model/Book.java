package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Integer ID;
    private String title;
    private Float avg_rating;
    private String isbn;
    private String isbn13;
    private String lang_code;
    private Integer num_pages;
    private Integer ratings_count;
    private Date publication_date; //may have problem with format?
    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_author_rel",
            joinColumns = {@JoinColumn(name="bookID")},
            inverseJoinColumns = { @JoinColumn(name = "authorID") })
    private List<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<UserBookInteraction> reviews;

    public Book(String title, Float avg_rating, String isbn, String isbn13, String lang_code, Integer num_pages,
                Integer ratings_count, Date publication_date, Publisher publisher, List<Author> authors) {
        this.title = title;
        this.avg_rating = avg_rating;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.lang_code = lang_code;
        this.num_pages = num_pages;
        this.ratings_count = ratings_count;
        this.publication_date = publication_date;
        this.publisher = publisher;
        this.authors = authors;
    }
}
