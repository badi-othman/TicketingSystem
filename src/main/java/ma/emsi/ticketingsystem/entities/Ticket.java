package ma.emsi.ticketingsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.ticketingsystem.enums.Criticality;
import ma.emsi.ticketingsystem.enums.Products;
import ma.emsi.ticketingsystem.enums.Services;
import ma.emsi.ticketingsystem.enums.Status;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;

@Entity @Data @Builder @NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String version;
    private Date dateCreation;

    @Enumerated
    private Status status;

    @Enumerated
    private Products productType;

    @Enumerated
    private Services serviceType;

    @Enumerated
    private Criticality criticality;

    @ManyToOne
    private Utilisateur client;

    @ManyToOne
    private Consultant consultant;

}
