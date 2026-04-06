package com.bookmyshow.service;

import com.bookmyshow.entity.User;
import com.bookmyshow.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
      User user = repo.findByUsername(username)
              .orElseThrow(()->new UsernameNotFoundException("user not found"));

              return org.springframework.security.core.userdetails.User
                      .withUsername(user.getUsername())
                      .password(user.getPassword())
                      .authorities("USER")
                      .build();

    }
}
