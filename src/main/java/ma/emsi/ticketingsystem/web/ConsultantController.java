package ma.emsi.ticketingsystem.web;

import lombok.AllArgsConstructor;
import ma.emsi.ticketingsystem.entities.Consultant;
import ma.emsi.ticketingsystem.entities.Ticket;
import ma.emsi.ticketingsystem.enums.Status;
import ma.emsi.ticketingsystem.repos.TicketRepository;
import ma.emsi.ticketingsystem.service.ConsultantService;
import ma.emsi.ticketingsystem.service.TicketService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ConsultantController {
    private ConsultantService consultantService;

    private TicketService ticketService;

    private TicketRepository ticketRepository;

    @GetMapping("/consultant/tickets")
    public String TicketsByConsultantID(Model model, Authentication auth) {
        String username = auth.getName();
        List<Ticket> tickets = ticketRepository.findByUsernameConsultant(username);
        model.addAttribute("tickets", tickets);
        return "consultant-tickets";
    }

    @PostMapping("consultant/tickets/update/{ticketID}")
    public String UpdateTicketStatus(@PathVariable Long ticketID) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketID);


        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();

            if (ticket.getStatus().equals(Status.OPEN)) {
                ticket.setStatus(Status.IN_PROGRESS);
            }
            else if (ticket.getStatus().equals(Status.IN_PROGRESS)) {
                ticket.setStatus(Status.CLOSED);
            }

            ticketRepository.save(ticket);

        }

        return "redirect:/consultant/tickets";
    }
}
