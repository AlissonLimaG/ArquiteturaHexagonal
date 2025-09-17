package com.aquitetura.hexagonal.projetohexagonal.adapters.out.persistence.sqlServer.entity;

import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "clientes")
public class JpaClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;

    public JpaClienteEntity() {
    }

    public JpaClienteEntity(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Cliente toModel() {
        return new Cliente(getId(), getNome(), getEmail());
    }
}

