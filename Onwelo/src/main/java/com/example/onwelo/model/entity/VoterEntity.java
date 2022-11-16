package com.example.onwelo.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Getter
@Setter
@Builder
@Entity
@Table(name = "voters")
public class VoterEntity extends BaseEntity {
    private String firstName;
    private String secondName;
    @JoinColumn(name = "candidates_id")
    @ManyToOne
    private CandidateEntity candidate;

    public VoterEntity(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public VoterEntity() {

    }

    public VoterEntity(String firstName, String secondName, CandidateEntity candidate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.candidate = candidate;
    }

    public VoterEntity withCandidate(CandidateEntity candidate) {
        return VoterEntity.builder().candidate(candidate.addNewVotes(this)).build();
    }
}
