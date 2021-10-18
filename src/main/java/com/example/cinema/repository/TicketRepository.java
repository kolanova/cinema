package com.example.cinema.repository;

import com.example.cinema.model.Ticket;
import com.example.cinema.model.TicketTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Set<Ticket> findByTicketTime(TicketTime morning);
}
