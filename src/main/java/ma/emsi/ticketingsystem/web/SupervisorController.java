package ma.emsi.ticketingsystem.web;

import lombok.AllArgsConstructor;
import ma.emsi.ticketingsystem.entities.Consultant;
import ma.emsi.ticketingsystem.entities.Ticket;
import ma.emsi.ticketingsystem.repos.ConsultantRepository;
import ma.emsi.ticketingsystem.service.ConsultantService;
import ma.emsi.ticketingsystem.service.SupervisorService;
import ma.emsi.ticketingsystem.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class SupervisorController {
    private SupervisorService supervisorService;

    private TicketService ticketService;

    private ConsultantRepository consultantRepository;

    @GetMapping("/supervisor/tickets")
    public String AllTickets(Model model) {
        List<Ticket> tickets = ticketService.findAll();
        List<Consultant> consultants = consultantRepository.findAll();
        model.addAttribute("tickets", tickets);
        model.addAttribute("consultants", consultants);
        return "supervisor-tickets";
    }

    @PostMapping("/supervisor/tickets/assign/{ticketId}")
    public String AssignTicket(@PathVariable Long ticketId, @RequestParam String consultantUsername) {
        Ticket ticket = ticketService.findById(ticketId);
        Consultant consultant = consultantRepository.findByUsername(consultantUsername);
        ticket.setConsultant(consultant);
        ticketService.save(ticket);

        return "redirect:/supervisor/tickets";
    }
}
