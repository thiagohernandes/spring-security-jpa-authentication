package com.security.springsecurityjpaauthentication.config;

import com.security.springsecurityjpaauthentication.filter.AuthenticationLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(
                new AuthenticationLoggingFilter(),
                BasicAuthenticationFilter.class)
            .authorizeRequests()
            .antMatchers("/teste").hasAuthority("TESTE")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/index", true)
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .permitAll()
            .logoutSuccessUrl("/exit?logout=true")
            .invalidateHttpSession(true)
            .permitAll()
            .and()
            .csrf()
            .disable();
    }

}
