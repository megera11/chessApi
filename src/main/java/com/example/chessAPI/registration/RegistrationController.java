package com.example.chessAPI.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
    public String register(@RequestParam(value="login") String login,
                         @RequestParam(value="password") String password,
                         @RequestParam(value="matchingPassowrd") String matchingPassword,
                         @RequestParam(value="nick") String nick){


    }
}
