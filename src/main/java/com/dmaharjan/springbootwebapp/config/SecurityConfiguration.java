package com.dmaharjan.springbootwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/", "/*todo*/**").access("hasRole('USER')")
            .and().formLogin();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService()
    {
        UserDetails user = User.withDefaultPasswordEncoder().username("dilip").password("dilip").roles("USER").build();

        return new InMemoryUserDetailsManager(user);
    }
}
