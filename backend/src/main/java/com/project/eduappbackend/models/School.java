package com.project.eduappbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="schools")
@Getter
@Setter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="schooltype_id", referencedColumnName = "schooltype_id", nullable = false)
    private SchoolType schoolType;
}
