package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserBookInteraction {

    @Id
    @GeneratedValue
    private Integer ID;

    Boolean readFlag;
    Boolean readingList;
    Boolean like;
    Integer rating;
    String review_text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
