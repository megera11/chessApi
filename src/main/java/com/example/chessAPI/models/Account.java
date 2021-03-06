package com.example.chessAPI.models;

import com.example.chessAPI.annotations.Matches;
import com.example.chessAPI.annotations.UniqueLogin;
import com.example.chessAPI.annotations.UniqueNick;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@NoArgsConstructor

@Entity(name="Accounts")
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
@Matches(field="password",verifyField = "confirmedPassword")
public class Account {
    public Account(String username, String password,String confirmedPassword,String nick){
        this.username=username;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.nick = nick;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @UniqueLogin
    @Getter
    @Setter
    private String username;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String password;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    @Transient
    private String confirmedPassword;

    @NotNull
    @NotEmpty
    @UniqueNick
    @Getter
    @Setter
    private String nick;

}
