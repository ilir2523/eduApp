package com.project.eduappbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="quizes")
@Getter
@Setter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private int quizId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="room_id", referencedColumnName = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
}
