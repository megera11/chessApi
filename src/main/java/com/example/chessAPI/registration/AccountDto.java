package com.example.chessAPI.registration;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

public class AccountDto {

    @Setter
    @Getter
    @NotNull
    private String login;

    @Setter
    @Getter
    @NotNull
    private String password;

    @Setter
    @Getter
    @NotNull
    private String confirmedPassword;
    
    @Setter
    @Getter
    @NotNull
    private String nick;

}
