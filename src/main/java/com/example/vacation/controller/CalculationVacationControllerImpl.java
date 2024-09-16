package com.example.vacation.controller;

import com.example.vacation.controller.impl.CalculationVacationController;
import com.example.vacation.service.CalculationVacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalculationVacationControllerImpl implements CalculationVacationController {

    private final CalculationVacationService calculationVacationService;

    @Override
    public Integer calculationOfVacationPay(Integer averageSalary, Integer vacationDays) {
        return calculationVacationService.calculationOfVacationPay(averageSalary, vacationDays);
    }
}
