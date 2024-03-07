package com.learnsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .authorizeHttpRequests((authz) -> authz.requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("NORMAL_USER")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("aditya")
                .password(this.passwordEncoder().encode("admin"))
                .roles("ADMIN_USER")
                .build();



        return new InMemoryUserDetailsManager(user1,user2);
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
