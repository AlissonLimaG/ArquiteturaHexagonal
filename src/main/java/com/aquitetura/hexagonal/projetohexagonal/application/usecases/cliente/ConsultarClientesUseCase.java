package com.aquitetura.hexagonal.projetohexagonal.application.usecases.cliente;

import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;
import com.aquitetura.hexagonal.projetohexagonal.domain.ports.out.ClienteRepositoryPort;

import java.util.List;

public class ConsultarClientesUseCase {

    private final ClienteRepositoryPort repository;

    public ConsultarClientesUseCase(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    public List<Cliente> execute() {
        return repository.findAll();
    }
}
