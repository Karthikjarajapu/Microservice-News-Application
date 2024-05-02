package com.wipro.mvc.security;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MvcSecurity {

    @Value("${SECRET}")
    private String secret;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.withUsername("user").password(passwordEncoder().encode(secret))
                .roles("NORMAL").build();
        UserDetails adminUser = User.withUsername("adm").password(passwordEncoder().encode(secret)).roles("ADMIN")
                .build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(normalUser);
        inMemoryUserDetailsManager.createUser(adminUser);

        return inMemoryUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().authorizeHttpRequests()
                .requestMatchers("/home/dashboard-admin").hasRole("ADMIN")
                .requestMatchers("/home/dashboard-normal").hasRole("NORMAL")
                .requestMatchers("/home/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();

        return httpSecurity.build();
    }
}
