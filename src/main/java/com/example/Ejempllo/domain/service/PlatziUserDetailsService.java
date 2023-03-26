package com.example.Ejempllo.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service//Debido a que es un serviico que se inyectara despues
public class PlatziUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("Sergio", "{noop}Rodriguez", new ArrayList<>()); //El array es tipos de roles. noop codifica
    }
}
