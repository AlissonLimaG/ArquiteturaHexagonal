package com.aquitetura.hexagonal.projetohexagonal.adapters.in.dto;

import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;

public class ClienteDto {
    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Cliente toModel() {
        return new Cliente(nome, email);
    }
}
