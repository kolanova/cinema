package com.example.cinema.service;

import com.example.cinema.model.Ticket;
import com.example.cinema.model.TicketTime;
import com.example.cinema.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Set<Ticket> getAllTickets() {
        return Set.copyOf(this.ticketRepository.findAll());
    }

    public Set<Ticket> getAllMornings() {
        return this.ticketRepository.findByTicketTime(TicketTime.MORNING);
    }

    public Set<Ticket> getAllDays() {
        return this.ticketRepository.findByTicketTime(TicketTime.DAY);
    }

    public Set<Ticket> getAllNights() {
        return this.ticketRepository.findByTicketTime(TicketTime.NIGHT);
    }
}