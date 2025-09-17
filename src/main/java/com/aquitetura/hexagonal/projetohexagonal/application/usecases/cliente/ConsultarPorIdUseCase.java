package com.aquitetura.hexagonal.projetohexagonal.application.usecases.cliente;

import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;
import com.aquitetura.hexagonal.projetohexagonal.domain.ports.out.ClienteRepositoryPort;

import java.util.UUID;

public class ConsultarPorIdUseCase {

    private final ClienteRepositoryPort repository;

    public ConsultarPorIdUseCase(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    public Cliente execute(UUID id) {
        return repository.findById(id).orElse(null);
    }
}
