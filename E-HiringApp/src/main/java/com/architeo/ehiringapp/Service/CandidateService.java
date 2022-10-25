package com.architeo.ehiringapp.Service;

import com.architeo.ehiringapp.Model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    public List<Candidate> getCandidates();
    public Candidate updateCandidate( Long id,Candidate candidate) throws Exception;
    public Optional<Candidate> getCandidateById(Long id);
    public Candidate saveCandidate(Candidate candidate);
}
