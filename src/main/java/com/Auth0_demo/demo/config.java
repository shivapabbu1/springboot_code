package com.Auth0_demo.demo;



import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class config  {

   

    @Bean
    public SecurityFilterChain  securityFilterChain ( HttpSecurity http) throws Exception {
    	 return http
                 .authorizeHttpRequests((authorize) -> authorize
                     .requestMatchers("/api/public").permitAll()
                     .requestMatchers("/api/private").authenticated()
                     .requestMatchers("/api/private-scoped").hasAuthority("SCOPE_read:message")
                 )
                 .cors(withDefaults())
                 .oauth2ResourceServer(oauth2 -> oauth2
                     .jwt(withDefaults())
                 )
                 .build();
     }
 }