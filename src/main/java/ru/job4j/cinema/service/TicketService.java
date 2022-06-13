package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.persistence.TicketDbStore;

import java.util.Collection;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketDbStore store;

    public TicketService(TicketDbStore store) {
        this.store = store;
    }

    public Optional<Ticket> add(Ticket ticket) {
        return store.add(ticket);
    }

    public Collection<Ticket> findAllSessionTickets(int sessionId) {
        return store.findAllSessionTickets(sessionId);
    }


}
