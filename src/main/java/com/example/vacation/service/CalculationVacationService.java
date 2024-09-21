package com.example.vacation.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface CalculationVacationService {
    /**
     * @param averageSalary Среднедневная зп за 12 мес
     * @param vacationDays  Количество дней отпуска
     * @return Сумма отпускных
     */
    Integer calculationOfVacationPay(Integer averageSalary, Integer vacationDays);

    /**
     * @param averageSalary Среднедневная зп за 12 мес
     * @param start         Дата начала отпуска
     * @param end           Дата конца отпуска
     * @return Сумма отпускных(выходные дни оплачиваются по обычному расчету, празднечные дни не оплачиваются)
     */
    Integer calculationOfVacationPayDate(Integer averageSalary, LocalDate start, LocalDate end);
}
