package com.architeo.ehiringapp.ServiceImpl;
import com.architeo.ehiringapp.Model.Candidate;
import com.architeo.ehiringapp.Repository.CandidateRepository;
import com.architeo.ehiringapp.Service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    @Override
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate updateCandidate(Long id,Candidate candidate) throws Exception {
        Candidate c=candidateRepository.findById(id).orElseThrow(()->new Exception("Candidate does not exist !"));
        System.out.println("the candidate is : "+c.toString());
        if(candidate.getPreselection()!=null) {
            c.setPreselection(candidate.getPreselection());
        }
        if(candidate.getDecisionRh()!=null){
            c.setDecisionRh(candidate.getDecisionRh());
        }
        if(candidate.getDecisionTech()!=null){
            c.setDecisionTech(candidate.getDecisionTech());
        }
        if(candidate.getDecisionFinal()!=null) {
            c.setDecisionFinal(candidate.getDecisionFinal());
        }
        if(candidate.getComment()!=null){
            c.setComment(candidate.getComment());
        }

        return candidateRepository.save(c);
    }

    @Override
    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {

        return candidateRepository.save(candidate);
    }
}
