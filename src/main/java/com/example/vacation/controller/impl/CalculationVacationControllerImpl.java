package com.example.vacation.controller.impl;

import com.example.vacation.controller.CalculationVacationController;
import com.example.vacation.service.CalculationVacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CalculationVacationControllerImpl implements CalculationVacationController {

    private final CalculationVacationService calculationVacationService;

    @Override
    public Integer calculationOfVacationPay(Integer averageSalary, Integer vacationDays) {
        return calculationVacationService.calculationOfVacationPay(averageSalary, vacationDays);
    }

    @Override
    public Integer calculationOfVacationPayDate(Integer averageSalary, LocalDate start, LocalDate end) {
        return calculationVacationService.calculationOfVacationPayDate(averageSalary, start, end);
    }
}
