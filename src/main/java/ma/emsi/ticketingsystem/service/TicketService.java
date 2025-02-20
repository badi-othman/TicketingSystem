package ma.emsi.ticketingsystem.service;

import ma.emsi.ticketingsystem.entities.Consultant;
import ma.emsi.ticketingsystem.entities.Ticket;
import ma.emsi.ticketingsystem.entities.Utilisateur;
import ma.emsi.ticketingsystem.repos.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findByClient(Utilisateur client) {
        return ticketRepository.findByClient(client);
    }

    public List<Ticket> findByConsultant(Consultant consultant) {
        return ticketRepository.findByConsultant(consultant);
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }
}
