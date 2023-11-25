package com.example.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(name = "second_name")
    private String secondName;

    @Column(nullable = false, name = "date_of_birth", columnDefinition = "DATE")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "person")
    private Set<BrokerAccount> accounts;
}
