package com.solars.SolarWeb.Service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserService {

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User("chisisolar@gmail.com",
                    "chisisolar2023",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")))
    );

    public UserDetails findByEmail(String email){
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException(" User Not Found"));
    }
}
