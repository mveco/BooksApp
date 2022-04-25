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

}
