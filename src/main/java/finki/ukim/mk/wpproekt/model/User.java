package finki.ukim.mk.wpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private String username;
    private String password;
    private String name;
    private String lastName;
    private Integer age;
    private String address;
    private String quote;

    @OneToMany(mappedBy = "user")
    private List<UserBookInteraction> reviews;

}
