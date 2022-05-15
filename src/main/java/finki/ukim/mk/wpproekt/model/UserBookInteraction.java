package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserBookInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    boolean readFlag;
    boolean readingList;
    boolean like;
    Integer rating;
    String reviewText;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public UserBookInteraction(User user, Book book, boolean readFlag, boolean readingList, boolean like, Integer rating, String reviewText) {
        this.readFlag = readFlag;
        this.readingList = readingList;
        this.like = like;
        this.rating = rating;
        this.reviewText = reviewText;
        this.user = user;
        this.book = book;
    }
}
