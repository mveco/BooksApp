package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserReviews {

    @Id
    @GeneratedValue
    private Integer ID;

    String review_text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
