package com.aquitetura.hexagonal.projetohexagonal.application.usecases.cliente;

import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;
import com.aquitetura.hexagonal.projetohexagonal.domain.ports.out.ClienteRepositoryPort;

import java.util.UUID;

public class AtualizarClienteUseCase {

    private final ClienteRepositoryPort repository;

    public AtualizarClienteUseCase(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    public Cliente execute(UUID uuid, Cliente cliente) {
       return repository.update(uuid, cliente);
    }
}
