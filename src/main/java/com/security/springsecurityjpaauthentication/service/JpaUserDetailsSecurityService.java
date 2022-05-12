package com.security.springsecurityjpaauthentication.service;

import com.security.springsecurityjpaauthentication.entity.UserEntity;
import com.security.springsecurityjpaauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.function.Supplier;

@Service
public class JpaUserDetailsSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsSecurityService loadUserByUsername(String username) {
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException("Problem during authentication!");

        UserEntity u = userRepository.findUserByUsername(username).orElseThrow(s);

        return new UserDetailsSecurityService(u);
    }
}
