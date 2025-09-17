package com.aquitetura.hexagonal.projetohexagonal.adapters.out.persistence.sqlServer.repository;

import com.aquitetura.hexagonal.projetohexagonal.adapters.out.persistence.sqlServer.entity.JpaClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ClienteJpaRepository extends JpaRepository<JpaClienteEntity, UUID> {}

