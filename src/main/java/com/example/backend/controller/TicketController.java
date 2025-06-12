package com.example.backend.controller;

import org.springframework.web.bind.annotation.*;
import com.example.backend.model.Ticket;
import com.example.backend.model.Cliente;
import com.example.backend.repository.TicketRepository;
import com.example.backend.repository.ClienteRepository;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketRepository ticketRepo;
    private final ClienteRepository clienteRepo;

    public TicketController(TicketRepository ticketRepo, ClienteRepository clienteRepo) {
        this.ticketRepo = ticketRepo;
        this.clienteRepo = clienteRepo;
    }

    @GetMapping
    public List<Ticket> listar() {
        return ticketRepo.findAll();
    }

    @GetMapping("/{id}")
    public Ticket buscar(@PathVariable Long id) {
        return ticketRepo.findById(id).orElse(null);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Ticket> listarPorCliente(@PathVariable Long clienteId) {
        return ticketRepo.findByClienteId(clienteId);
    }

    @PostMapping
    public Ticket criar(@RequestBody Ticket ticket) {
        associarCliente(ticket);
        return ticketRepo.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket atualizar(@PathVariable Long id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        associarCliente(ticket);
        return ticketRepo.save(ticket);
    }

    private void associarCliente(Ticket ticket) {
        if (ticket.getCliente() != null && ticket.getCliente().getId() != null) {
            Cliente cliente = clienteRepo.findById(ticket.getCliente().getId()).orElse(null);
            ticket.setCliente(cliente);
        } else {
            ticket.setCliente(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        ticketRepo.deleteById(id);
    }
}