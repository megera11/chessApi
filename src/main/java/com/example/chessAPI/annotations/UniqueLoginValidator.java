package com.example.chessAPI.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.chessAPI.models.Account;
import com.example.chessAPI.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String>{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Account> list = accountRepository.findAllByUsername(value);
        return  accountRepository.findAllByUsername(value).isEmpty();
    }
}
