package com.loginpage.login.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						.anyRequest().authenticated()
				)
				.formLogin((form) -> form
						.loginPage("/login")
						.permitAll()
						.defaultSuccessUrl("/home",true)
				);

		return http.build();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
				User.withDefaultPasswordEncoder()
						.username("user")
						.password("password")
						.build();
        UserDetails admin=
				User.withDefaultPasswordEncoder()
						.username("Joel")
						.password("1234")
						.build();
		return new InMemoryUserDetailsManager(user,admin);
	}
}