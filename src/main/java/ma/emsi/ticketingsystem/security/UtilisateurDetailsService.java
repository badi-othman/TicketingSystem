package ma.emsi.ticketingsystem.security;

import ma.emsi.ticketingsystem.entities.Consultant;
import ma.emsi.ticketingsystem.entities.Supervisor;
import ma.emsi.ticketingsystem.entities.Utilisateur;
import ma.emsi.ticketingsystem.repos.ClientRepository;
import ma.emsi.ticketingsystem.repos.ConsultantRepository;
import ma.emsi.ticketingsystem.repos.SupervisorRepository;
import ma.emsi.ticketingsystem.service.ClientService;
import ma.emsi.ticketingsystem.service.ConsultantService;
import ma.emsi.ticketingsystem.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurDetailsService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ConsultantRepository consultantRepository;

    @Autowired
    SupervisorRepository supervisorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = clientRepository.findByUsername(username);
        if (utilisateur != null) {
            return new User(utilisateur.getUsername(), utilisateur.getPassword(), AuthorityUtils.createAuthorityList("ROLE_CLIENT"));
        }

        Consultant consultant = consultantRepository.findByUsername(username);
        if (consultant != null) {
            return new User(consultant.getUsername(), consultant.getPassword(), AuthorityUtils.createAuthorityList("ROLE_CONSULTANT"));
        }

        Supervisor supervisor = supervisorRepository.findByUsername(username);
        if (supervisor != null) {
            return new User(supervisor.getUsername(), supervisor.getPassword(), AuthorityUtils.createAuthorityList("ROLE_SUPERVISOR"));
        }

        throw new UsernameNotFoundException("User not found");
    }
}
