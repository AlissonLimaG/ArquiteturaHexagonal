package com.aquitetura.hexagonal.projetohexagonal.domain.ports.out;

import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(UUID id);
    List<Cliente> findAll();
    boolean delete(UUID uuid);
    Cliente update(UUID id,Cliente cliente);
}

