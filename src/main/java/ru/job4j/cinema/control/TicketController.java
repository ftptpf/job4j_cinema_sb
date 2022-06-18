package ru.job4j.cinema.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.service.TicketService;

import java.util.Objects;

@Controller
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping("/tickets")
    public String freeTickets(Model model) {
        Session session = (Session) model.getAttribute("filmSession");
        int id = Objects.requireNonNull(session).getId();
        model.addAttribute("sessionTickets", service.findAllSessionTickets(id));
        return "tickets";
    }

}
