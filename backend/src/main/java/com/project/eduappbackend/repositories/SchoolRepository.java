package com.project.eduappbackend.repositories;

import com.project.eduappbackend.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("select s from School s where s.schoolId = :id")
    School findById(Integer id);

    List<School> findAll();

    @Query("select s from School s where s.schoolType.type = :schoolType")
    List<School> findBySchoolType(String schoolType);
}
