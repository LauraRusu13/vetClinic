package com.sda.vetClinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> {

            auth.requestMatchers("/registration").permitAll();
            auth.requestMatchers("/loginSuccessful").permitAll();
            auth.requestMatchers("/logout").permitAll();
            auth.requestMatchers("/navbar").permitAll();


            auth.requestMatchers("/css/*").permitAll();
            auth.requestMatchers("/img/*").permitAll();

            auth.requestMatchers("/homepageVeterinarian").hasRole("VETERINARIAN");
            auth.requestMatchers("/homepageOwner").hasRole("OWNER");


            auth.requestMatchers("/addPet").hasRole("OWNER");
            auth.requestMatchers("/addAppointment").hasRole("OWNER");



        }).httpBasic();

        httpSecurity
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/loginSuccessful").permitAll()

                .and()

                .logout().permitAll()
                .and()
                .csrf().disable().authorizeHttpRequests()
                .and()
                .cors().disable().authorizeHttpRequests();

        // end schelet
        return httpSecurity.build();
    }

}
