package dmp.beeline.ru.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "users")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue
    Long id;
    @Column(length = 256)
    String username;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String email;
    @Column
    String phone;
}
