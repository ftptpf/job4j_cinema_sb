package ru.job4j.cinema.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.service.TicketService;
import ru.job4j.cinema.util.UserUtil;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping("/ticket")
    public String freeTickets(Model model, HttpSession session) {
        UserUtil.checkAndSetGuestName(model, session);
        Session filmSession = (Session) model.getAttribute("filmSession");
        int id = Objects.requireNonNull(filmSession).getId();
        model.addAttribute("sessionTickets", service.findSessionTickets(id));
        return "ticket";
    }

}
