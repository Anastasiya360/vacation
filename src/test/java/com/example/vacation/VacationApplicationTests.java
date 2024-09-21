package com.example.vacation;

import com.example.vacation.exception.ApiException;
import com.example.vacation.service.CalculationVacationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class VacationApplicationTests {

    @Autowired
    private CalculationVacationService calculationVacationService;

    @Test
    void calculationOfVacationPayTest() {
        Integer result = calculationVacationService.calculationOfVacationPay(1500, 14);
        Assertions.assertEquals(21000, result);
    }

    @Test
    void calculationOfVacationPayDateTest() {
        Integer result = calculationVacationService.calculationOfVacationPayDate(1500, LocalDate.parse("2024-02-21"), LocalDate.parse("2024-02-24"));
        Assertions.assertEquals(4500, result);
    }

    @Test
    void calculationOfVacationPayDateAverageSalaryNull() {
        ApiException thrown = Assertions.assertThrows(ApiException.class, () -> {
            calculationVacationService.calculationOfVacationPayDate(null, LocalDate.parse("2024-02-21"), LocalDate.parse("2024-02-24"));
        });
        Assertions.assertEquals(400, thrown.getStatusCode());
        Assertions.assertEquals("Сумма средней зп не передана", thrown.getMessage());
    }

    @Test
    void calculationOfVacationPayDateAverageSalaryNotValid() {
        ApiException thrown = Assertions.assertThrows(ApiException.class, () -> {
            calculationVacationService.calculationOfVacationPayDate(-1, LocalDate.parse("2024-02-21"), LocalDate.parse("2024-02-24"));
        });
        Assertions.assertEquals(400, thrown.getStatusCode());
        Assertions.assertEquals("Сумма средней зп задана неверно", thrown.getMessage());
    }

    @Test
    void calculationOfVacationPayDateStartNull() {
        ApiException thrown = Assertions.assertThrows(ApiException.class, () -> {
            calculationVacationService.calculationOfVacationPayDate(1500, null, LocalDate.parse("2024-02-24"));
        });
        Assertions.assertEquals(400, thrown.getStatusCode());
        Assertions.assertEquals("Дата начала отпуска не передана", thrown.getMessage());
    }

    @Test
    void calculationOfVacationPayDateEndNull() {
        ApiException thrown = Assertions.assertThrows(ApiException.class, () -> {
            calculationVacationService.calculationOfVacationPayDate(1500, LocalDate.parse("2024-02-21"), null);
        });
        Assertions.assertEquals(400, thrown.getStatusCode());
        Assertions.assertEquals("Дата конца отпуска не передана", thrown.getMessage());
    }

    @Test
    void calculationOfVacationPayDateNotValid() {
        ApiException thrown = Assertions.assertThrows(ApiException.class, () -> {
            calculationVacationService.calculationOfVacationPayDate(1500, LocalDate.parse("2024-02-26"), LocalDate.parse("2024-02-24"));
        });
        Assertions.assertEquals(400, thrown.getStatusCode());
        Assertions.assertEquals("Конечная дата раньше начальной", thrown.getMessage());
    }
}
