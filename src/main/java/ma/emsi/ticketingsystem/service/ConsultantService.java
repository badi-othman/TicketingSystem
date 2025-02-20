package ma.emsi.ticketingsystem.service;

import ma.emsi.ticketingsystem.entities.Consultant;
import ma.emsi.ticketingsystem.repos.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantService {
    @Autowired
    private ConsultantRepository consultantRepository;

    public Consultant save(Consultant consultant) {
        return consultantRepository.save(consultant);
    }

    public List<Consultant> findAll() {
        return consultantRepository.findAll();
    }

    public Consultant findById(Long id) {
        return consultantRepository.findById(id).orElse(null);
    }
}
