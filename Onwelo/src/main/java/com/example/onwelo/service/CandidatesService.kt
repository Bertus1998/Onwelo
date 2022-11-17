package com.example.onwelo.service

import com.example.onwelo.exception.EntityNotFoundException
import com.example.onwelo.exception.NotValidStringException
import com.example.onwelo.mapper.toEntity
import com.example.onwelo.mapper.toResponse
import com.example.onwelo.mapper.toResponseList
import com.example.onwelo.model.CandidateRs
import com.example.onwelo.model.CreateCandidateRq
import com.example.onwelo.model.entity.CandidateEntity
import com.example.onwelo.repository.CandidateRepository
import com.example.onwelo.utils.Utils
import lombok.AllArgsConstructor
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
@AllArgsConstructor
 class CandidatesService(
    private val utils: Utils,
    private val candidateRepository: CandidateRepository
) {
    open fun findOrThrow(id: UUID): CandidateEntity {
        return candidateRepository.findByIdOrNull(id)
            ?: throw EntityNotFoundException("Candidate with id $id was not found")
    }

    fun createCandidate(createCandidateRq: CreateCandidateRq): CandidateRs {
        validateCandidate(createCandidateRq)
        return candidateRepository.save(createCandidateRq.toEntity()).toResponse()
    }
    open fun findAllCandidates(): List<CandidateRs> {
        return candidateRepository.findAll().toResponseList()
    }

    private fun validateCandidate(createCandidateRq: CreateCandidateRq) {
        if (utils.isBlankOrNull(createCandidateRq.firstName)) throw NotValidStringException("Firstname blank or null")
        if (utils.isBlankOrNull(createCandidateRq.secondName)) throw NotValidStringException("Secondname blank or null")
    }
}