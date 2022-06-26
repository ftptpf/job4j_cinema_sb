package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.persistence.SessionDbStore;

import java.util.Collection;
import java.util.List;

@Service
public class SessionService {
    private final SessionDbStore store;
    private final TicketService service;

    public SessionService(SessionDbStore store, TicketService service) {
        this.store = store;
        this.service = service;
    }

    public Collection<Session> findAll() {
        return store.findAll();
    }

    public Session findById(int id) {
        return store.findById(id);
    }

    public boolean[][] orderedTickets(int id) {
        boolean[][] result = new boolean[4][4];
        List<Ticket> ticketList = (List<Ticket>) service.findSessionTickets(id);
        for (Ticket ticket : ticketList) {
            int row = ticket.getRow();
            int cell = ticket.getCell();
            result[row][cell] = true;
        }
        return result;
    }
}
