package com.example.chessAPI.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.chessAPI.models.Account;
import com.example.chessAPI.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String>{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Account> list = accountRepository.findAllByLogin(value);
        return  accountRepository.findAllByLogin(value).isEmpty();
    }
}
