package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_book")
public class UserBookInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    Integer rating;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public UserBookInteraction(User user, Book book) {
        this.user = user;
        this.book = book;
        this.rating = null;
    }

    public UserBookInteraction() {

    }
}
