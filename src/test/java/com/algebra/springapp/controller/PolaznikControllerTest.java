package com.algebra.springapp.controller;

import com.algebra.springapp.model.Polaznik;
import com.algebra.springapp.service.PolaznikService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = PolaznikController.class)
class PolaznikControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockitoBean
    private PolaznikService service;

    @Test
    void getAllReturnsOk() throws Exception {
        Polaznik p = new Polaznik(); p.setPolaznikId(1L); p.setIme("Ivo"); p.setPrezime("Ivic");
        when(service.findAll()).thenReturn(List.of(p));
        mvc.perform(get("/api/polaznici").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].ime").value("Ivo"));
    }
}
