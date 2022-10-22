package com.project.eduappbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="rooms_users")
@Getter
@Setter
public class RoomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomsusers_id")
    private int classUserId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="room_id", referencedColumnName = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
}
