package com.example.vacation.service.impl;

import org.springframework.stereotype.Service;

@Service
public interface CalculationVacationService {

    Integer calculationOfVacationPay(Integer averageSalary, Integer vacationDays);
}
