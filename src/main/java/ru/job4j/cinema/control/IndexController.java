package ru.job4j.cinema.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.cinema.service.SessionService;

@Controller
public class IndexController {
    private final SessionService service;

    public IndexController(SessionService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("sessions", service.findAll());
        return "index";
    }
}
