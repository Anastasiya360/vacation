package com.example.vacation.service.impl;

import com.example.vacation.exception.ApiException;
import com.example.vacation.service.CalculationVacationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationVacationServiceImpl implements CalculationVacationService {

    /**
     * Список праздничных дней
     */
    private List<LocalDate> holidaysDate(Integer year) {

        List<LocalDate> holidays = new ArrayList<>();

        holidays.add(LocalDate.of(year, 1, 1));  // Новый год
        holidays.add(LocalDate.of(year, 1, 2));  // Новый год
        holidays.add(LocalDate.of(year, 1, 3));  // Новый год
        holidays.add(LocalDate.of(year, 1, 4));  // Новый год
        holidays.add(LocalDate.of(year, 1, 5));  // Новый год
        holidays.add(LocalDate.of(year, 1, 6));  // Новый год
        holidays.add(LocalDate.of(year, 1, 7));  // Рождество
        holidays.add(LocalDate.of(year, 1, 8));  // Новый год
        holidays.add(LocalDate.of(year, 2, 23)); // День защитника Отечества
        holidays.add(LocalDate.of(year, 3, 8));  // Международный женский день
        holidays.add(LocalDate.of(year, 5, 1));  // Праздник Весны и Труда
        holidays.add(LocalDate.of(year, 5, 9));  // День Победы
        holidays.add(LocalDate.of(year, 6, 12)); // День России
        holidays.add(LocalDate.of(year, 11, 4)); // День народного единства

        return holidays;
    }

    @Override
    public Integer calculationOfVacationPay(Integer averageSalary, Integer vacationDays) {
        return averageSalary * vacationDays;
    }

    @Override
    public Integer calculationOfVacationPayDate(Integer averageSalary, LocalDate start, LocalDate end) {
        if (averageSalary == null) {
            throw new ApiException("Сумма средней зп не передана", HttpServletResponse.SC_BAD_REQUEST);
        }
        if (averageSalary <= 0) {
            throw new ApiException("Сумма средней зп задана неверно", HttpServletResponse.SC_BAD_REQUEST);
        }
        if (start == null) {
            throw new ApiException("Дата начала отпуска не передана", HttpServletResponse.SC_BAD_REQUEST);
        }
        if (end == null) {
            throw new ApiException("Дата конца отпуска не передана", HttpServletResponse.SC_BAD_REQUEST);
        }
        if (start.isAfter(end)) {
            throw new ApiException("Конечная дата раньше начальной", HttpServletResponse.SC_BAD_REQUEST);
        }
        Integer vacationDays = calculateWorkdays(start, end);

        return calculationOfVacationPay(averageSalary, vacationDays);
    }

    /**
     * Проверка наличия празднечных дней в период отпуска
     *
     * @param start Дата начала отпуска
     * @param end   Дата окончания отпуска
     * @return Дни для расчета отпускных
     */
    private Integer calculateWorkdays(LocalDate start, LocalDate end) {
        Integer days = 1;
        List<LocalDate> holidays = holidaysDate(start.getYear());
        while (start.isBefore(end)) {
            if (!holidays.contains(start)) {
                days++;
            }
            start = start.plusDays(1);
        }
        return days;
    }
}
