package com.example.onwelo.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="candidates")
@NoArgsConstructor
public class CandidateEntity extends BaseEntity {
    @NotNull
    private String firstName;
    @NotNull
    private String secondName;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy="candidate", orphanRemoval=true)
    private Set<VoterEntity> voters;

    public Set<VoterEntity> getVoters() {
        return voters;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public CandidateEntity(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.voters = new HashSet<VoterEntity>();
    }

    public CandidateEntity addNewVotes(VoterEntity voterEntity){
        this.voters.add(voterEntity);
        return this;
    }
}