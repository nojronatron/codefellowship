package com.fellowshipOfTheCode.jrCodeFellowship.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.AppRepository;

@Service
public class UserDetailsSvcImplementation implements UserDetailsService {
    @Autowired
    AppRepository appRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appRepository.findByUsername(username);
    }
}
