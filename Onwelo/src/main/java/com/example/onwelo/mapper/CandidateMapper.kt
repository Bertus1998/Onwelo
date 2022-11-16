package com.example.onwelo.mapper

import com.example.onwelo.model.CandidateRs
import com.example.onwelo.model.CreateCandidateRq
import com.example.onwelo.model.entity.CandidateEntity


fun CreateCandidateRq.toEntity(): CandidateEntity = CandidateEntity(this.firstName,this.secondName)

fun List<CandidateEntity>.toResponseList() = this.map { it.toResponse() }

fun CandidateEntity.toResponse() = CandidateRs()
    .also {
        it.secondName = this.secondName
        it.firstName = this.firstName
        it.id = this.id
        it.votesNumber = this.voters.count()
    }