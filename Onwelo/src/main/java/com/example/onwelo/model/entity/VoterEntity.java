package com.example.onwelo.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;


@Getter
@Setter
@Builder
@Entity
@Table(name = "voters")
public class VoterEntity extends BaseEntity {
    private String firstName;
    private String secondName;

    @ManyToOne( cascade = CascadeType.REMOVE)
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
         this.setCandidate(candidate.addNewVotes(this));
         return this;
    }
    public void removeCandidate(){
         this.setCandidate(null);
    }
}
