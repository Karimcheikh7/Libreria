package com.karimCheikh.libreria.security;

import com.karimCheikh.libreria.service.UserWorkerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    //beans
    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserWorkerService userWorkerService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userWorkerService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer.anyRequest().permitAll());

//                         Chiamate Libro
//                        .requestMatchers(HttpMethod.GET, "/api/libri").hasRole("DIPENDENTE")
//                        .requestMatchers(HttpMethod.GET, "/api/libri/**").hasRole("DIPENDENTE")
//                        .requestMatchers(HttpMethod.POST, "/api/libri").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.PUT, "/api/libri").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.DELETE, "/api/libri/**").hasRole("ADMIN")
//
//                         Chiamate Editore
//                        .requestMatchers(HttpMethod.GET, "/api/editori").hasRole("DIPENDENTE")
//                        .requestMatchers(HttpMethod.GET, "/api/editori/**").hasRole("DIPENDENTE")
//                        .requestMatchers(HttpMethod.POST, "/api/editori").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.PUT, "/api/editori").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.DELETE, "/api/editori/**").hasRole("ADMIN")
//
//                         Chiamate Vendite
//                        .requestMatchers(HttpMethod.GET, "/api/vendite").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/vendite/**").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/venditaLibri/**").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/vendita/**").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/venditaData/**").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/venditeData/**").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/api/vendite").permitAll()
//                        .requestMatchers(HttpMethod.DELETE, "/api/vendite/**").permitAll()
//
//                         Chiamate User
//                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.GET, "/api/user/**").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.PUT, "/api/users").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
//
//                         Chiamate Ordini
//                        .requestMatchers(HttpMethod.GET, "/api/ordini").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.GET, "/api/ordine/**").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.POST, "/api/ordini").hasRole("RESPONSABILE")
//                        .requestMatchers(HttpMethod.DELETE, "/api/ordini/**").hasRole("ADMIN"));


        // use HTTP Basic authentication
        http.httpBasic();

        // disable Cross Site Request Forgery (CSRF)
        // in general not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf().disable();

        return http.build();
    }
}