package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String name;

//    @OneToMany(mappedBy = "publisher")
//    private List<Book> books;

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

}
