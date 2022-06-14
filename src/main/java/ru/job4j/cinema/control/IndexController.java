package ru.job4j.cinema.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.cinema.service.SessionService;
import ru.job4j.cinema.service.TicketService;

import java.util.Optional;

@Controller
public class IndexController {
    private final SessionService service;
    private final TicketService ticketService;

    public IndexController(SessionService service, TicketService ticketService) {
        this.service = service;
        this.ticketService = ticketService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("sessions", service.findAll());
        Optional<Integer> idOptional = (Optional<Integer>) model.getAttribute("filmSession.id");
        if (idOptional.isPresent()) {
            int id = idOptional.get();
            model.addAttribute("sessionTickets", ticketService.findAllSessionTickets(id));
        }

        return "index";
    }
}
