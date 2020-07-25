package com.example.resttest;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "users")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = true, length = 200)
    private String password;

}