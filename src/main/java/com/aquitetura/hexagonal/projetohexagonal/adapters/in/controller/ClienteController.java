package com.aquitetura.hexagonal.projetohexagonal.adapters.in.controller;

import com.aquitetura.hexagonal.projetohexagonal.application.usecases.cliente.*;
import com.aquitetura.hexagonal.projetohexagonal.domain.models.Cliente;
import com.aquitetura.hexagonal.projetohexagonal.adapters.in.dto.ClienteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final AtualizarClienteUseCase atualizarClienteUseCase;
    private final RemoverClienteUseCase removerClienteUseCase;
    private final ConsultarClientesUseCase consultarClientesUseCase;
    private final ConsultarPorIdUseCase consultarPorIdUseCase;
    private final AdicionarClienteUseCase adicionarClienteUseCase;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(consultarClientesUseCase.execute());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable UUID id) {
        Cliente cliente = consultarPorIdUseCase.execute(id);
        if(cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> adicionarCliente(@RequestBody ClienteDto cliente) {
        var novoCliente = adicionarClienteUseCase.execute(cliente.toModel());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                             .path("/{id}")
                                             .buildAndExpand(novoCliente.getId())
                                             .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void>  atualizarliente(@PathVariable UUID id ,@RequestBody ClienteDto cliente) {
        var clienteAtualizado = atualizarClienteUseCase.execute(id ,cliente.toModel());
        if(clienteAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>  removerCliente(@PathVariable UUID id) {
        if(!removerClienteUseCase.execute(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}