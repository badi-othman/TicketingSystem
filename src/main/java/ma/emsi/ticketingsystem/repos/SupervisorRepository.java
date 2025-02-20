package ma.emsi.ticketingsystem.repos;

import ma.emsi.ticketingsystem.entities.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
    Supervisor findByUsername(String username);
}
