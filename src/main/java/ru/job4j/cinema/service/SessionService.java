package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.persistence.SessionDbStore;

import java.util.Collection;

@Service
public class SessionService {
    private final SessionDbStore store;

    public SessionService(SessionDbStore store) {
        this.store = store;
    }

    public Collection<Session> findAll() {
        return store.findAll();
    }

}
