package com.aquitetura.hexagonal.projetohexagonal.application.usecases.cliente;

import com.aquitetura.hexagonal.projetohexagonal.domain.ports.out.ClienteRepositoryPort;

import java.util.UUID;

public class RemoverClienteUseCase {

    private final ClienteRepositoryPort repository;

    public RemoverClienteUseCase(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    public boolean execute(UUID id) {
        return repository.delete(id);
    }
}
