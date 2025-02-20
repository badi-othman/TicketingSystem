package ma.emsi.ticketingsystem.web;

import lombok.AllArgsConstructor;
import ma.emsi.ticketingsystem.entities.Ticket;
import ma.emsi.ticketingsystem.entities.Utilisateur;
import ma.emsi.ticketingsystem.enums.Status;
import ma.emsi.ticketingsystem.repos.ClientRepository;
import ma.emsi.ticketingsystem.repos.TicketRepository;
import ma.emsi.ticketingsystem.service.ClientService;
import ma.emsi.ticketingsystem.service.TicketService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    private TicketService ticketService;

    private TicketRepository ticketRepository;

    private ClientRepository clientRepository;

    @GetMapping("/client/tickets")
    public String TicketsByClientId(Model model, Authentication auth) {
        String username = auth.getName();
        List<Ticket> tickets = ticketRepository.findByUsernameClient(username);
        model.addAttribute("tickets", tickets);
        return "client-tickets";
    }

    @GetMapping("/client/ticket-form")
    public String createTicketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket-form";
    }

    @PostMapping("/client/tickets/save")
    public String createTicket(@ModelAttribute("ticket") Ticket ticket, Authentication auth) {
        String username = auth.getName();
        Utilisateur utilisateur = clientRepository.findByUsername(username);
        ticket.setClient(utilisateur);
        ticket.setConsultant(null);
        ticket.setStatus(Status.OPEN);
        ticket.setDateCreation(new Date());
        ticketService.save(ticket);

        return "redirect:/client/tickets";
    }

}
