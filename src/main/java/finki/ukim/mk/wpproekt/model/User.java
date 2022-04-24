package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String name;
    private String surname;
    private Integer age;
    private String address;
    private String quote;

    @OneToMany(mappedBy = "user")
    private List<UserReviews> reviews;

}
