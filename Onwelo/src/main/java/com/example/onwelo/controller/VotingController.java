package com.example.onwelo.controller;

import com.example.onwelo.api.VotingApi;
import com.example.onwelo.service.VotingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class VotingController implements VotingApi {
    private final VotingService votingService;

    @Override
    public ResponseEntity<Void> voteOnCandidate(UUID voterId, UUID candidateId) {
        votingService.executeVoting(voterId, candidateId);
        return ResponseEntity.ok().build();
    }
}
