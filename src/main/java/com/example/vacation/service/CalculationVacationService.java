package com.example.vacation.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationVacationService {
    public Integer calculationOfVacationPay(Integer averageSalary, Integer vacationDays){
        return averageSalary*vacationDays;
    }
}
