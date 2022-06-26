package ru.job4j.cinema.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.service.SessionService;
import ru.job4j.cinema.service.TicketService;
import ru.job4j.cinema.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class TicketController {
    private final TicketService service;
    private final SessionService sessionService;

    public TicketController(TicketService service, SessionService sessionService) {
        this.service = service;
        this.sessionService = sessionService;
    }

    @PostMapping("/ticket")
    public String orderTickets(Model model, HttpSession session, HttpServletRequest request) {
        var paramMap = request.getParameterMap();
        int sessionId = Integer.parseInt(paramMap.get("sessionId")[0]);
        int row = Character.getNumericValue(paramMap.get("rowcell")[0].charAt(0));
        int cell = Character.getNumericValue(paramMap.get("rowcell")[0].charAt(1));
        int userId = Integer.parseInt(paramMap.get("userId")[0]);
        Optional<Ticket> ticket = service.add(new Ticket(sessionId, row, cell, userId));
        if (ticket.isEmpty()) {
            model.addAttribute("message", "Ошибка при бронировании билета");
            model.addAttribute("ticket", new Ticket());
        } else {
            model.addAttribute("message", "Операция бронирования билета прошла успешно");
            model.addAttribute("ticket", ticket.get());
            model.addAttribute("film", sessionService.findById(sessionId));
        }
        UserUtil.checkAndSetGuestName(model, session);
        return "result";
    }
}
