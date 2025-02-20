package ma.emsi.ticketingsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
    @Autowired
    private UtilisateurDetailsService userDetailsService;

    @Autowired CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize->authorize
                .requestMatchers("/client/**").hasRole("CLIENT")
                .requestMatchers("/consultant/**").hasRole("CONSULTANT")
                .requestMatchers("/supervisor/**").hasRole("SUPERVISOR")
                .requestMatchers("/login").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated()
        )
                .formLogin(form->form
                        .loginPage("/login")
                        .successHandler(customAuthenticationSuccessHandler)
                        .permitAll()
                )
                .logout(logout->logout
                        .logoutSuccessUrl("/login")
                );
        return http.build();
    }
    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
