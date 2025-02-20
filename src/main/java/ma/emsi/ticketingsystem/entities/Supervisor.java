package ma.emsi.ticketingsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.ticketingsystem.enums.Roles;

@Entity
@Data @NoArgsConstructor @Builder
@AllArgsConstructor
public class Supervisor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;
}
