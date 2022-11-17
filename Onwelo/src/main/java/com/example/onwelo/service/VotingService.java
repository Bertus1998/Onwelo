package com.example.onwelo.service;

import com.example.onwelo.model.entity.CandidateEntity;
import com.example.onwelo.model.entity.VoterEntity;
import com.example.onwelo.repository.VotersRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VotingService {

    public VotingService(CandidatesService candidatesService,
                         VotersService votersService,
                         VotersRepository votersRepository) {
        this.candidatesService = candidatesService;
        this.votersService = votersService;
        this.votersRepository = votersRepository;
    }

    private final CandidatesService candidatesService;
    private final VotersService votersService;
    private final VotersRepository votersRepository;


    public void executeVoting(UUID voterId, UUID candidateId) {
        VoterEntity voters = votersService.findOrThrow(voterId);
        CandidateEntity candidate = candidatesService.findOrThrow(candidateId);

        boolean relatedAlready = voters.getCandidate() != null;
        boolean sameCandidateAsAlready = false;

        if (relatedAlready) {
            sameCandidateAsAlready = voters.getCandidate().getId() == candidateId;
        }

        if (!sameCandidateAsAlready) {
            voters.removeCandidate();
            votersRepository.save(voters);
        }

        if (!sameCandidateAsAlready) {
            updateVoting(voters.withCandidate(candidate));
        }
    }

    private void updateVoting(VoterEntity voter) {
        votersRepository.save(voter);
    }
}
