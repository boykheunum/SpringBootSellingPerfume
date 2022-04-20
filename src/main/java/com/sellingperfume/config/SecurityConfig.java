package com.sellingperfume.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sellingperfume.services.impl.SecuritySpringBoot;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  SecuritySpringBoot securitySpringBoot;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // TODO Auto-generated method stub
    http.csrf().disable();
    http.authorizeRequests().antMatchers("/admin/**").authenticated().anyRequest().permitAll()
        .and().formLogin().loginProcessingUrl("/j_spring_security_check")
        .loginPage("/login").permitAll().defaultSuccessUrl("/login?thanhcong", true)
        .failureUrl("/login?thatbai").usernameParameter("username")//
        .passwordParameter("password");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // TODO Auto-generated method stub
    auth.userDetailsService(securitySpringBoot).passwordEncoder(passwordEncoder());
  }
}
