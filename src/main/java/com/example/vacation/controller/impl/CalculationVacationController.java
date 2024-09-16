package com.example.vacation.controller.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Calculation", description = "Calculation of vacation pay")
public interface CalculationVacationController {

    @Operation(summary = "Calculation of vacation pay")
    @GetMapping(path = "calculation/vacation")
    Integer calculationOfVacationPay(
            @Parameter(description = "Average salary amount") @RequestParam Integer averageSalary,
            @Parameter(description = "Number of vacation days") @RequestParam Integer vacationDays);
}
