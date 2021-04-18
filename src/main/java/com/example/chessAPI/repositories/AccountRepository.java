package com.example.chessAPI.repositories;

import com.example.chessAPI.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("accountRepository")
public interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findAllByLogin(String login);

    List<Account> findAllByNick(String nick);
}
