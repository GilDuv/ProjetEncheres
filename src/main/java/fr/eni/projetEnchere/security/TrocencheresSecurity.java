package fr.eni.projetEnchere.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class TrocencheresSecurity {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/modification").permitAll()	
//				.requestMatchers("/", "/films", "/css/*").permitAll()
//				.requestMatchers("/creer").hasRole("MEMBRE")
//				.requestMatchers("/adminGenres").hasRole("ADMINISTRATEUR")
//				.requestMatchers("/").permitAll()
//				.requestMatchers("/profilCreation").hasRole("Utilisateur")
//				.requestMatchers("/").hasRole("Utilisateur")

				.anyRequest().permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/connexion")
				.permitAll()
				.defaultSuccessUrl("/")
			)
			//.csrf().disable()
			.logout((logout) -> logout.permitAll()
					.logoutSuccessUrl("/"));

		return http.build();
	}
	
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
