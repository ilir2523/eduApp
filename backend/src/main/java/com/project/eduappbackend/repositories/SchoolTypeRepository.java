package com.project.eduappbackend.repositories;

import com.project.eduappbackend.models.SchoolType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolTypeRepository extends JpaRepository<SchoolType, Long> {
    @Query("select s from SchoolType s where s.type = :type")
    SchoolType findByType(String type);

    @Query("select s from SchoolType s where s.schoolTypeId=:id")
    SchoolType findBySchoolTypeId(Integer id);


}
