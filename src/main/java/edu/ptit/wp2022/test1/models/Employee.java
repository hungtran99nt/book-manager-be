package edu.ptit.wp2022.test1.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "dob", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dob;
    @Column(name = "department", nullable = false)
    private String department;
    @Column(name = "hired", nullable = false)
    private boolean hired;
}
