package ma.emsi.ticketingsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.ticketingsystem.enums.Roles;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @Builder
@AllArgsConstructor
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Ticket> createdTickets = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        createdTickets.add(ticket);
        ticket.setClient(this);
    }
}
