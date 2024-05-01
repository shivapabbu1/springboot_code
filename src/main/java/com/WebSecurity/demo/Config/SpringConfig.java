package com.WebSecurity.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfig {
	
	//authnetication
	@Bean
    public UserDetailsService userDetailsService() {
    	
    	
    	UserDetails user = User.withUsername("pabbu")
    			.password(passwordEncoder().encode("1234"))
    			.roles("USER")
    			.build();
    	UserDetails admin = User.withUsername("admin")
    			.password(passwordEncoder().encode("1234"))
    			.roles("ADMIN")
    			.build();
    	return new InMemoryUserDetailsManager(user,admin);
 }
	
	//Authurization

		@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/welcome").permitAll()
				
				.anyRequest().authenticated()
			).httpBasic(Customizer.withDefaults());
			
			return http.build();
	               
	        
	     

	       
	    }
	
	@Bean
	public  PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	
	

  

	  
    
}
