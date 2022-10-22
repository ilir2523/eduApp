package com.project.eduappbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="schooltypes")
@Getter
@Setter
public class SchoolType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schooltype_id")
    private int schoolTypeId;

    @Column(name = "type")
    private String type;
}
