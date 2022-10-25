package com.architeo.ehiringapp.Repository;

import com.architeo.ehiringapp.Model.Candidate;
import com.architeo.ehiringapp.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
