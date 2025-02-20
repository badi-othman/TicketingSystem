package ma.emsi.ticketingsystem.repos;

import ma.emsi.ticketingsystem.entities.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    Consultant findByUsername(String username);
}
