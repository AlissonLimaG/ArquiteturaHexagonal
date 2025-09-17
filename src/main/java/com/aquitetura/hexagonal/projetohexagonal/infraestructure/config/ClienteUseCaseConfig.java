package com.aquitetura.hexagonal.projetohexagonal.infraestructure.config;

import com.aquitetura.hexagonal.projetohexagonal.application.usecases.cliente.*;
import com.aquitetura.hexagonal.projetohexagonal.domain.ports.out.ClienteRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteUseCaseConfig {

    @Bean
    public AdicionarClienteUseCase adicionarClienteUseCase(ClienteRepositoryPort repository) {
        return new AdicionarClienteUseCase(repository);
    }

    @Bean
    public RemoverClienteUseCase removerClienteUseCase(ClienteRepositoryPort repository) {
        return new RemoverClienteUseCase(repository);
    }

    @Bean
    public ConsultarClientesUseCase consultarClientesUseCase(ClienteRepositoryPort repository) {
        return new ConsultarClientesUseCase(repository);
    }

    @Bean
    public ConsultarPorIdUseCase consultarPorIdUseCase(ClienteRepositoryPort repository) {
        return new ConsultarPorIdUseCase(repository);
    }

    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(ClienteRepositoryPort repository) {
        return new AtualizarClienteUseCase(repository);
    }
}
