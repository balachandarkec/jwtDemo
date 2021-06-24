package com.bala.authorization.JwtDemo.service;

import com.bala.authorization.JwtDemo.model.Account;
import com.bala.authorization.JwtDemo.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserAccountRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user=repository.findByUserName(username);
        return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
    }
}
