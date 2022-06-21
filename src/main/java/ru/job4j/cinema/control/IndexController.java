package ru.job4j.cinema.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.cinema.service.SessionService;
import ru.job4j.cinema.util.UserUtil;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    private final SessionService service;

    public IndexController(SessionService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        UserUtil.checkAndSetGuestName(model, session);
        model.addAttribute("sessions", service.findAll());
        return "index";
    }
}
