package com.example.backend.controller;

import org.springframework.web.bind.annotation.*;
import com.example.backend.model.Cliente;
import com.example.backend.repository.ClienteRepository;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository repo;

    public ClienteController(ClienteRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Cliente> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) { return repo.save(cliente); }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return repo.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}