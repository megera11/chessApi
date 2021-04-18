package com.example.chessAPI;

import com.example.chessAPI.models.Account;
import com.example.chessAPI.registration.RegistrationController;
import com.example.chessAPI.repositories.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(RegistrationController.class)
public class AccountValidationTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    AccountRepository accountRepository;



    @Test
    public void passDiff() throws Exception {
        Account account = new Account("megera11","haslo","haslo11","kozaklp");
        mvc.perform(MockMvcRequestBuilders.post("/registration")
                .content(new ObjectMapper().writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void allgood() throws Exception {
        Account account = new Account("Jan123","haslo","haslo","janek");
        mvc.perform(MockMvcRequestBuilders.post("/registration")
                .content(new ObjectMapper().writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }



}
