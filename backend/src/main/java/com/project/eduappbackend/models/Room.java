package com.project.eduappbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="rooms")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "name")
    private String name;

    @Column(name = "visible")
    private boolean visible;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="topic_id", referencedColumnName = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="schooltype_id", referencedColumnName = "schooltype_id", nullable = false)
    private SchoolType schoolType;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="creator_id", referencedColumnName = "user_id", nullable = false)
    private User creator;
}
