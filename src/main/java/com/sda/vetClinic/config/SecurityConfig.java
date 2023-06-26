//package com.sda.vetClinic.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(auth -> {
//
//            auth.requestMatchers("/registration").permitAll();
//            auth.requestMatchers("/login").permitAll();
//
//            auth.requestMatchers("/css/*").permitAll();
//
//            auth.requestMatchers("/homepageVeterinarian").hasRole("VETERINARIAN");
//            auth.requestMatchers("/homepageOwner").hasRole("OWNER");
//            auth.requestMatchers("/addPet").hasRole("OWNER");
//
//
//
//        }).httpBasic();
//
//        httpSecurity
//                .formLogin()
//                .loginPage("/login").defaultSuccessUrl("/homepageVeterinarian")
//                .and().logout().permitAll()
//
//                .and().csrf().disable().cors().disable()
//                .exceptionHandling().accessDeniedPage("/error"); //TODO error page
//
//        return httpSecurity.build();
//    }
//
//}
