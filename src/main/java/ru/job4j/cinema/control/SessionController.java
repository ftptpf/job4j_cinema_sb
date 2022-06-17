package ru.job4j.cinema.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.service.SessionService;

@Controller
public class SessionController {
    private final SessionService service;

    public SessionController(SessionService service) {
        this.service = service;
    }
    @PostMapping("/session")
    public String sessionId(@ModelAttribute Session session, Model model) {
        model.addAttribute("filmSession", session);
        return "tickets";


    }
}
