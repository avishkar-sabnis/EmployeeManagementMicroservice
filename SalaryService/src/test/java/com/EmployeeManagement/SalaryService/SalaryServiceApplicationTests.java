package com.EmployeeManagement.SalaryService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class SalaryServiceApplicationTests {


    @InjectMocks
    SalaryService salaryService;

    @Mock
    SalaryDAO salaryDAO;
    @Test
    public void getAllSalaries(){
        Mockito.when(salaryDAO.findAll()).thenReturn
                (Stream.of
                        ((new Salary(1,"Avishkar",3294.00,110.0)),
                                (new Salary(1,"Avishkar",3294.00,110.0))
                        ).collect(Collectors.toList()));

        assertEquals(2,salaryService.getAllSalaries().size());
    }


}
