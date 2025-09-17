package com.aquitetura.hexagonal.projetohexagonal.application.usecases.cliente;

import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;
import com.aquitetura.hexagonal.projetohexagonal.domain.ports.out.ClienteRepositoryPort;


public class AdicionarClienteUseCase {

    private final ClienteRepositoryPort repository;

    public AdicionarClienteUseCase(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    public Cliente execute(Cliente cliente) {
        return repository.save(cliente);
    }
}
