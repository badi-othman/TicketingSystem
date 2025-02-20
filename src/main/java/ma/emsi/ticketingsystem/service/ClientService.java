package ma.emsi.ticketingsystem.service;

import ma.emsi.ticketingsystem.entities.Utilisateur;
import ma.emsi.ticketingsystem.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Utilisateur save(Utilisateur client) {
        return clientRepository.save(client);
    }

    public List<Utilisateur> findAll() {
        return clientRepository.findAll();
    }

    public Utilisateur findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
