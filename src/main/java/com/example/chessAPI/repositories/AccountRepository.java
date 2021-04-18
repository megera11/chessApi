package com.example.chessAPI.repositories;

import com.example.chessAPI.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findAllByLogin(String login);

    List<Account> findAllByNick(String nick);
}
