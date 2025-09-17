package com.aquitetura.hexagonal.projetohexagonal.adapters.out.persistence.sqlServer;

import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;
import com.aquitetura.hexagonal.projetohexagonal.domain.ports.out.ClienteRepositoryPort;
import com.aquitetura.hexagonal.projetohexagonal.adapters.in.InternalBusinessException;
import com.aquitetura.hexagonal.projetohexagonal.adapters.out.persistence.sqlServer.entity.JpaClienteEntity;
import com.aquitetura.hexagonal.projetohexagonal.adapters.out.persistence.sqlServer.repository.ClienteJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {
    private final ClienteJpaRepository jpa;

    public ClienteRepositoryAdapter(ClienteJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Cliente> findById(UUID id) {
        return jpa.findById(id)
                .map(e -> new Cliente(e.getId(), e.getNome(), e.getEmail()));
    }

    @Override
    public List<Cliente> findAll() {
        return jpa.findAll().stream()
                .map(e -> new Cliente(e.getId(), e.getNome(), e.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public Cliente save(Cliente cliente) {
        JpaClienteEntity clienteEntity = jpa.save(cliente.toEntity());
        return clienteEntity.toModel();
    }

    @Override
    public Cliente update(UUID id, Cliente cliente) {
        if(findById(id).isPresent()) {
            JpaClienteEntity entity = new JpaClienteEntity();
            entity.setId(id);
            entity.setNome(cliente.getNome());
            entity.setEmail(cliente.getEmail());
            entity = jpa.save(entity);
            return entity.toModel();
        }
        throw new InternalBusinessException("Cliente não encontrado.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public boolean delete(UUID uuid) {
        if(findById(uuid).isPresent()) {
            jpa.deleteById(uuid);
            return true;
        }
        return false;
    }

}

