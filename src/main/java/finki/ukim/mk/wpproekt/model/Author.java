package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue
    private Integer ID;
    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}
