package ru.job4j.cinema.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.service.SessionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SessionController {
    private final SessionService service;

    public SessionController(SessionService service) {
        this.service = service;
    }
    @PostMapping("/session")
    public String sessionId(HttpServletRequest req, Model model) {
        int id = Integer.parseInt(req.getParameter("id"));
        Session sessionWithName = service.findById(id);
        model.addAttribute("filmSession", sessionWithName);
        return "tickets";
    }
}
