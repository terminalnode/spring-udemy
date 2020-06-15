package com.example.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // Add temporary users
    UserBuilder users = User.withDefaultPasswordEncoder();
    auth.inMemoryAuthentication()
      .withUser(users.username("john").password("password").roles("EMPLOYEE"))
      .withUser(users.username("mary").password("password").roles("MANAGER"))
      .withUser(users.username("susan").password("password").roles("ADMIN"));
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .anyRequest()
      .authenticated()
    .and()
      .formLogin()
      .loginPage("/showLoginPage")
      .loginProcessingUrl("/auth")
      .permitAll()
    .and()
      .logout()
      .permitAll();
  }
}