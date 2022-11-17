package com.example.onwelo.service;

import com.example.onwelo.exception.EntityNotFoundException;
import com.example.onwelo.exception.NotValidStringException;
import com.example.onwelo.mapper.VotersMapper;
import com.example.onwelo.model.CreateVoterRq;
import com.example.onwelo.model.VoterRs;
import com.example.onwelo.model.entity.VoterEntity;
import com.example.onwelo.repository.VotersRepository;
import com.example.onwelo.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.NotActiveException;
import java.util.List;
import java.util.UUID;

@Service
public class VotersService {
    public VotersService(VotersRepository votersRepository, VotersMapper votersMapper, com.example.onwelo.utils.Utils utils) {
        this.votersRepository = votersRepository;
        this.votersMapper = votersMapper;
        this.utils = utils;
    }

    private final Utils utils;
    private final VotersRepository votersRepository;
    private final VotersMapper votersMapper;
    @Transactional(readOnly = true)
    public List<VoterRs> findAllVoters() {
        return votersMapper.voterEntityListToRs(votersRepository.findAll());
    }
    @Transactional(readOnly = true)
    VoterEntity findOrThrow(UUID id){
        return votersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Voter with id = %s not found.", id)));
    }

    public VoterRs createVoter(CreateVoterRq createVoterRq) {
        validateVoter(createVoterRq);
        return votersMapper.voteEntityToRs(votersRepository.save(votersMapper.createVoterRqToEntity(createVoterRq)));
    }

    private void validateVoter(CreateVoterRq createVoterRq) {
        if (utils.isBlankOrNull(createVoterRq.getFirstName()))
            throw new NotValidStringException("Firstname blank or null");
        if (utils.isBlankOrNull(createVoterRq.getSecondName()))
            throw new NotValidStringException("Secondname blank or null");
    }
}
