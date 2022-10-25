package com.architeo.ehiringapp.api;


import com.architeo.ehiringapp.Model.Candidate;
import com.architeo.ehiringapp.ServiceImpl.CandidateServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
@JsonIgnoreProperties
public class CandidateController {
    private final CandidateServiceImpl candidateService;

    /*@PostMapping("/uploadCandidate")
    public ResponseEntity<Candidate> saveCand(@RequestParam("file")MultipartFile file,@RequestParam("candidate") String cand) throws IOException {
        Candidate can=new ObjectMapper().readValue(cand,Candidate.class);
        can.setCv(file.getBytes());
        can.setFileName(file.getOriginalFilename());
        System.out.println(Arrays.toString(can.getCv()));
        System.out.println(can.getFileName());
        return ResponseEntity.ok().body(candidateService.saveCandidate(can));
    }*/
    @PostMapping("/api/saveCandidate")
    public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate c){
        return ResponseEntity.ok().body(candidateService.saveCandidate(c));
    }
    @GetMapping("/api/listCandidates")
    public ResponseEntity<List<Candidate>> getCandidates(){
        return ResponseEntity.ok().body(candidateService.getCandidates());
    }
    @PutMapping("/api/candidates/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") Long id,@RequestBody Candidate c) throws Exception {
        return ResponseEntity.ok().body(candidateService.updateCandidate(id,c));
    }
    @GetMapping("/api/candidate/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Long id) throws Exception {
        Candidate c=candidateService.getCandidateById(id).orElseThrow(()->
                new Exception("the candidate does not exist"));
           return ResponseEntity.ok(c);
    }
}
