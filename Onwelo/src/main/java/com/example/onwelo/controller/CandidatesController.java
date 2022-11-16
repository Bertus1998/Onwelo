package com.example.onwelo.controller;

import com.example.onwelo.api.CandidateApi;
import com.example.onwelo.model.CandidateRs;
import com.example.onwelo.model.CreateCandidateRq;
import com.example.onwelo.service.CandidatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Slf4j
public class CandidatesController implements CandidateApi {
    private final CandidatesService candidatesService;

    public CandidatesController(CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @Override
    public ResponseEntity<CandidateRs> createCandidate(CreateCandidateRq createCandidateRq) {
        return ResponseEntity.ok(candidatesService.createCandidate(createCandidateRq));
    }

    @Override
    public ResponseEntity<List<CandidateRs>> getCandidates() {
        return ResponseEntity.ok(candidatesService.findAllCandidates());
    }
}
