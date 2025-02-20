package ma.emsi.ticketingsystem;

import ma.emsi.ticketingsystem.entities.Consultant;
import ma.emsi.ticketingsystem.entities.Supervisor;
import ma.emsi.ticketingsystem.entities.Ticket;
import ma.emsi.ticketingsystem.entities.Utilisateur;
import ma.emsi.ticketingsystem.enums.*;
import ma.emsi.ticketingsystem.repos.ClientRepository;
import ma.emsi.ticketingsystem.repos.ConsultantRepository;
import ma.emsi.ticketingsystem.repos.SupervisorRepository;
import ma.emsi.ticketingsystem.repos.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class TicketingSystemApplication implements CommandLineRunner {
    @Autowired
    private TicketRepository ticketRepo;

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private ConsultantRepository consultantRepo;

    @Autowired
    private SupervisorRepository supervisorRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(TicketingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String password = "1234";
        Utilisateur client1 = new Utilisateur();
        client1.setName("Ahmed");
        client1.setRole(Roles.CLIENT);
        client1.setUsername("client1");
        client1.setPassword(passwordEncoder.encode(password));

        Utilisateur client2 = new Utilisateur();
        client2.setName("Karim");
        client2.setRole(Roles.CLIENT);
        client2.setUsername("client2");
        client2.setPassword(passwordEncoder.encode(password));

        Utilisateur client3 = new Utilisateur();
        client3.setName("Jean");
        client3.setRole(Roles.CLIENT);
        client3.setUsername("client3");
        client3.setPassword(passwordEncoder.encode(password));

        clientRepo.save(client1);
        clientRepo.save(client2);
        clientRepo.save(client3);

        Consultant consultant1 = new Consultant();
        consultant1.setName("Omar");
        consultant1.setRole(Roles.CONSULTANT);
        consultant1.setUsername("consultant1");
        consultant1.setPassword(passwordEncoder.encode(password));

        Consultant consultant2 = new Consultant();
        consultant2.setName("Amine");
        consultant2.setRole(Roles.CONSULTANT);
        consultant2.setUsername("consultant2");
        consultant2.setPassword(passwordEncoder.encode(password));

        consultantRepo.save(consultant1);
        consultantRepo.save(consultant2);

        Supervisor supervisor1 = new Supervisor();
        supervisor1.setName("Othman");
        supervisor1.setRole(Roles.SUPERVISOR);
        supervisor1.setUsername("supervisor1");
        supervisor1.setPassword(passwordEncoder.encode(password));
        supervisorRepo.save(supervisor1);

        Ticket ticket1 = new Ticket();
        ticket1.setTitle("Ticket 1");
        ticket1.setDescription("Ticket 1");
        ticket1.setVersion("1.0.0");
        ticket1.setDateCreation(new Date());
        ticket1.setStatus(Status.CLOSED);
        ticket1.setProductType(Products.SAGE100);
        ticket1.setServiceType(Services.COMPTABILITE_GESTION);
        ticket1.setCriticality(Criticality.LOW);
        ticket1.setClient(client1);
        ticket1.setConsultant(consultant1);
        ticketRepo.save(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setTitle("Ticket 2");
        ticket2.setDescription("Ticket 2");
        ticket2.setVersion("2.0.0");
        ticket2.setDateCreation(new Date());
        ticket2.setStatus(Status.CLOSED);
        ticket2.setProductType(Products.SAGE100);
        ticket2.setServiceType(Services.PAIE_RH);
        ticket2.setCriticality(Criticality.MEDIUM);
        ticket2.setClient(client2);
        ticket2.setConsultant(consultant1);
        ticketRepo.save(ticket2);

        Ticket ticket3 = new Ticket();
        ticket3.setTitle("Ticket 3");
        ticket3.setDescription("Ticket 3");
        ticket3.setVersion("3.0.0");
        ticket3.setDateCreation(new Date());
        ticket3.setStatus(Status.CLOSED);
        ticket3.setProductType(Products.SAGEX3);
        ticket3.setServiceType(Services.COMMERCE);
        ticket3.setCriticality(Criticality.HIGH);
        ticket3.setClient(client2);
        ticket3.setConsultant(consultant1);
        ticketRepo.save(ticket3);

        Ticket ticket4 = new Ticket();
        ticket4.setTitle("Ticket 4");
        ticket4.setDescription("Ticket 4");
        ticket4.setVersion("4.0.0");
        ticket4.setDateCreation(new Date());
        ticket4.setStatus(Status.CLOSED);
        ticket4.setProductType(Products.SAGE50);
        ticket4.setServiceType(Services.COMMERCE);
        ticket4.setCriticality(Criticality.LOW);
        ticket4.setClient(client3);
        ticket4.setConsultant(consultant2);
        ticketRepo.save(ticket4);

        client1.addTicket(ticket1);
        consultant1.addAssignedTicket(ticket1);

        client2.addTicket(ticket2);
        consultant1.addAssignedTicket(ticket2);

        client2.addTicket(ticket3);
        consultant1.addAssignedTicket(ticket3);

        client3.addTicket(ticket4);
        consultant2.addAssignedTicket(ticket4);
    }
}
