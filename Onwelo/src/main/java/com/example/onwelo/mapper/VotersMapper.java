package com.example.onwelo.mapper;

import com.example.onwelo.model.CreateVoterRq;
import com.example.onwelo.model.VoterRs;
import com.example.onwelo.model.entity.VoterEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VotersMapper   {
    public List<VoterRs> voterEntityListToRs(List<VoterEntity> entityList){
        return entityList.stream().map(this::voteEntityToRs).collect(Collectors.toList());
    }
    public VoterRs voteEntityToRs(VoterEntity entity){
        return new VoterRs()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .secondName(entity.getSecondName())
                .alreadyVoted(entity.getCandidate()!=null);
    }

    public VoterEntity createVoterRqToEntity(CreateVoterRq createVoterRq){
        return new VoterEntity(createVoterRq.getFirstName(),createVoterRq.getSecondName());
    }
}
