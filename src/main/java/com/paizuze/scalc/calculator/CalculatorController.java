package com.paizuze.scalc.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculator(@ModelAttribute Equation equation, Model model) {
        return "calculator";
    }

    @GetMapping("/calculator/add")
    public String add(@ModelAttribute Equation equation, Model model) {
        BigDecimal leftOperand = equation.getLeftOperand();
        BigDecimal rightOperand = equation.getRightOperand();
        BigDecimal result = leftOperand.add(rightOperand);

        model.addAttribute("result", result);
        return "calculator";
    }
    @GetMapping("/calculator/sub")
    public String sub(@ModelAttribute Equation equation, Model model) {
        BigDecimal leftOperand = equation.getLeftOperand();
        BigDecimal rightOperand = equation.getRightOperand();
        BigDecimal result = leftOperand.subtract(rightOperand);

        model.addAttribute("result", result);
        return "calculator";
    }
}
