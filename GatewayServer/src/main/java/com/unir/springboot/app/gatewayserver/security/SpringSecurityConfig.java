package com.unir.springboot.app.gatewayserver.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@EnableWebFluxSecurity
public class SpringSecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;

	@Bean
	SecurityWebFilterChain configure(ServerHttpSecurity http) {
		http.authorizeExchange((exchanges) -> exchanges
				.pathMatchers("/api/users/**").permitAll()
				.pathMatchers("/api/auth/**").permitAll()
				.pathMatchers("/api/products/**").hasRole("ADMIN")
				.anyExchange().authenticated());
		http.addFilterAt(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION);
		http.csrf(cs -> cs.disable());
		return http.build();
	}
}