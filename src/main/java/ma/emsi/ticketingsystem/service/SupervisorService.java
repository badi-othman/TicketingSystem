package ma.emsi.ticketingsystem.service;

import ma.emsi.ticketingsystem.entities.Supervisor;
import ma.emsi.ticketingsystem.repos.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {
    @Autowired
    private SupervisorRepository supervisorRepository;

    public Supervisor save(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    public List<Supervisor> findAll() {
        return supervisorRepository.findAll();
    }

    public Supervisor findById(Long id) {
        return supervisorRepository.findById(id).orElse(null);
    }
}
