package com.aquitetura.hexagonal.projetohexagonal.domain.models;

import com.aquitetura.hexagonal.projetohexagonal.adapters.out.persistence.sqlServer.entity.JpaClienteEntity;

import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nome;
    private String email;

    public Cliente(UUID id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public JpaClienteEntity toEntity() {
        return new JpaClienteEntity(nome, email);
    }
}

