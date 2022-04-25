package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserBookInteraction {

    @Id
    @GeneratedValue
    private Integer ID;

    boolean readFlag;
    boolean readingList;
    boolean likes;
    Integer rating;
    String reviewText;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
