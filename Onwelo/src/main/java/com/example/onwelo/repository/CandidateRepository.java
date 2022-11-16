package com.example.onwelo.repository;

import com.example.onwelo.model.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity,UUID> {
}
