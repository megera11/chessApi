package com.example.chessAPI.annotations;

import com.example.chessAPI.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNickValidator implements ConstraintValidator<UniqueNick, String> {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return accountRepository.findAllByNick(value).isEmpty();
    }
}
