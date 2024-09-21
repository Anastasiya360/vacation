package com.example.vacation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@Tag(name = "Calculation", description = "Calculation of vacation pay")
public interface CalculationVacationController {

    @Operation(summary = "Calculation of vacation pay")
    @GetMapping(path = "calculation/vacation")
    Integer calculationOfVacationPay(
            @Parameter(description = "Average salary amount") @RequestParam Integer averageSalary,
            @Parameter(description = "Number of vacation days") @RequestParam Integer vacationDays);

    @Operation(summary = "Calculation of vacation pay by dates")
    @GetMapping(path = "calculation/vacation/date")
    Integer calculationOfVacationPayDate(
            @Parameter(description = "Average salary amount") @RequestParam Integer averageSalary,
            @Parameter(description = "vacation start date") @RequestParam ("start date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate start,
            @Parameter(description = "vacation end date") @RequestParam ("end date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end);
}
