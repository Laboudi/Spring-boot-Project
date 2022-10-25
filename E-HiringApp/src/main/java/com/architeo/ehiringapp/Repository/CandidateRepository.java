package com.architeo.ehiringapp.Repository;

import com.architeo.ehiringapp.Model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
