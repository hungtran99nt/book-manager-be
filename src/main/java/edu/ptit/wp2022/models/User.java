package edu.ptit.wp2022.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", unique = true, length = 30, nullable = false)
    private String username;

    @Column(name = "password", length = 75, nullable = false)
    private String password;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "type", length = 10, nullable = false)
    private String type;
}
