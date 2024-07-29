package com.motorcyclebg.service.impl;

import com.motorcyclebg.service.ExRateService;
import com.motorcyclebg.service.exception.ApiObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CurrencyControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExRateService exRateService;

    @Test
    public void testConvert() throws Exception {

        BigDecimal mockResult = new BigDecimal("100.00");
        when(exRateService.convert(anyString(), anyString(),
                any(BigDecimal.class))).thenReturn(mockResult);

        mockMvc.perform(get("/api/convert")
                        .param("from", "USD")
                        .param("to", "EUR")
                        .param("amount", "50"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.from").value("USD"))
                .andExpect(jsonPath("$.to").value("EUR"))
                .andExpect(jsonPath("$.amount").value(50))
                .andExpect(jsonPath("$.result").value(100.00));
    }

    @Test
    public void testConvert_notFound() throws Exception {

        when(exRateService.convert(anyString(), anyString(),
                any(BigDecimal.class))).thenThrow(new ApiObjectNotFoundException("Currency pair not found", "USD-EUR"));
        mockMvc.perform(get("/api/convert")
                        .param("from", "USD")
                        .param("to", "EUR")
                        .param("amount", "50"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("NOT FOUND"))
                .andExpect(jsonPath("$.id").value("USD-EUR"));

    }

}