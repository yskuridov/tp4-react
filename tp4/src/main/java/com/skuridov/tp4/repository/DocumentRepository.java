package com.skuridov.tp4.repository;

import com.skuridov.tp4.model.Document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Optional<Document> getDocumentById(long id);
}
