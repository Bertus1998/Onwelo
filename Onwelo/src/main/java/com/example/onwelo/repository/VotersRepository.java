package com.example.onwelo.repository;

import com.example.onwelo.model.entity.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VotersRepository extends JpaRepository<VoterEntity,UUID > {
}
