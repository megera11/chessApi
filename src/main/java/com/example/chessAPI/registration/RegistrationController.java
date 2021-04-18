package com.example.chessAPI.registration;

import com.example.chessAPI.models.Account;
import com.example.chessAPI.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping
    @ResponseStatus(value= HttpStatus.OK)
    public void register(@Valid @RequestBody Account account){
        accountRepository.save(account);
    }
}
