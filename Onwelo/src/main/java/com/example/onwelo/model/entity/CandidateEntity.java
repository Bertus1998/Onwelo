package com.example.onwelo.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="candidates")
@Builder
@AllArgsConstructor
public class CandidateEntity extends BaseEntity {
    @NotNull
    private String firstName;
    @NotNull
    private String secondName;
    @OneToMany
    @Builder.Default
    private Set<VoterEntity> voters = new HashSet<VoterEntity>();

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
    }

    public CandidateEntity addNewVotes(VoterEntity voterEntity){
        this.voters.add(voterEntity);
        return this;
    }
}