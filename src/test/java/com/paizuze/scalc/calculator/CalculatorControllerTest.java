package com.paizuze.scalc.calculator;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String PATH = "/calculator";

    @Test
    public void calculatorShouldReturnCalculatorPageWithNoResult() throws Exception {
        this.mockMvc.perform(get(PATH))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Campo A:")))
                .andExpect(content().string(containsString("Campo B:")))
                .andExpect(content().string(doesNotContainString("O resultado é:")));
    }

    @Test
    public void addShouldReturnCalculatorPageWithFormatErrorLeftOperand() throws Exception {
        this.mockMvc.perform(get(PATH + "/add")
                        .param("leftOperand", "asdasd")
                        .param("rightOperand", "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Campo A:")))
                .andExpect(content().string(containsString("Campo B:")))
                .andExpect(content().string(containsString("Formato de operando inválido")));
    }

    @Test
    public void addShouldReturnCalculatorPageWithFormatErrorRightOperand() throws Exception {
        this.mockMvc.perform(get(PATH + "/add")
                        .param("leftOperand", "1")
                        .param("rightOperand", "asdasd")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Campo A:")))
                .andExpect(content().string(containsString("Campo B:")))
                .andExpect(content().string(containsString("Formato de operando inválido")));
    }


    @Test
    public void addShouldReturnCalculatorPageWithCorrectResult() throws Exception {
        this.mockMvc.perform(get(PATH + "/add")
                        .param("leftOperand", "1")
                        .param("rightOperand", "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Campo A:")))
                .andExpect(content().string(containsString("Campo B:")))
                .andExpect(content().string(containsString("O resultado é: 2")));
    }

    @Test
    public void subShouldReturnCalculatorPageWithFormatErrorLeftOperand() throws Exception {
        this.mockMvc.perform(get(PATH + "/sub")
                        .param("leftOperand", "asdasd")
                        .param("rightOperand", "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Campo A:")))
                .andExpect(content().string(containsString("Campo B:")))
                .andExpect(content().string(containsString("Formato de operando inválido")));
    }

    @Test
    public void subShouldReturnCalculatorPageWithFormatErrorRightOperand() throws Exception {
        this.mockMvc.perform(get(PATH + "/sub")
                        .param("leftOperand", "1")
                        .param("rightOperand", "asdasd")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Campo A:")))
                .andExpect(content().string(containsString("Campo B:")))
                .andExpect(content().string(containsString("Formato de operando inválido")));
    }


    @Test
    public void subShouldReturnCalculatorPageWithCorrectResult() throws Exception {
        this.mockMvc.perform(get(PATH + "/sub")
                        .param("leftOperand", "1")
                        .param("rightOperand", "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Campo A:")))
                .andExpect(content().string(containsString("Campo B:")))
                .andExpect(content().string(containsString("O resultado é: 0")));
    }

    private Matcher<String> doesNotContainString(String s) {
        return CoreMatchers.not(containsString(s));
    }
}
