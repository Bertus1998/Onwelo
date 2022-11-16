package com.example.onwelo.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
@Getter
@EqualsAndHashCode(of = "id")
public class BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    private final UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }
}
