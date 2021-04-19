package com.example.chessAPI.services;

import com.example.chessAPI.models.Account;
import com.example.chessAPI.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findOneAccountByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException(login);
        }
        return new org.springframework.security.core.userdetails.User(account.getLogin(), account.getPassword(), Collections.emptyList());
    }

}
