package com.project.eduappbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="school_id", referencedColumnName = "school_id", nullable = false)
    private School school;

    @Column(name = "password")
    private String password;
}
