package com.example.onwelo.controller;


import com.example.onwelo.api.VotersApi;
import com.example.onwelo.model.CreateVoterRq;
import com.example.onwelo.model.VoterRs;
import com.example.onwelo.service.VotersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Slf4j
public class VotersController implements VotersApi {
    private final VotersService votersService;

    public VotersController(VotersService votersService) {
        this.votersService = votersService;
    }

    @Override
    public ResponseEntity<VoterRs> createVoter(CreateVoterRq createVoterRq) {
        return ResponseEntity.ok(votersService.createVoter(createVoterRq));
    }

    @Override
    public ResponseEntity<List<VoterRs>> getVoters() {
        return ResponseEntity.ok(votersService.findAllVoters());
    }
}
