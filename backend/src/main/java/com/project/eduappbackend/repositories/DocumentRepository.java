package com.project.eduappbackend.repositories;

import com.project.eduappbackend.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query("select d from Document d where d.documentId = :documentId")
    Document findByDocumentId(Integer documentId);
}
