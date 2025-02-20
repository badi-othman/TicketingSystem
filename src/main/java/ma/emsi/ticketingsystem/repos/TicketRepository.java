package ma.emsi.ticketingsystem.repos;

import ma.emsi.ticketingsystem.entities.Consultant;
import ma.emsi.ticketingsystem.entities.Ticket;
import ma.emsi.ticketingsystem.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByClient(Utilisateur client);
    List<Ticket> findByConsultant(Consultant consultant);
    @Query("SELECT t FROM Ticket t WHERE t.client.username = :username")
    List<Ticket> findByUsernameClient(String username);
    @Query("SELECT t FROM Ticket t WHERE t.consultant.username = :username")
    List<Ticket> findByUsernameConsultant(String username);
}
