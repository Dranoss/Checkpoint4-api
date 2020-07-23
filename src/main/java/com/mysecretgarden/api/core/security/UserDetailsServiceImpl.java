package com.mysecretgarden.api.core.security;

import com.mysecretgarden.api.webServices.entities.Guardian;
import com.mysecretgarden.api.webServices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        Guardian guardian = userRepository.findByUsername(username);
        if (guardian == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(guardian.getUsername(), guardian.getPassword(), emptyList());
    }
}
