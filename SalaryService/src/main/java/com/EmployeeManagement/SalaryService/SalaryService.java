package com.EmployeeManagement.SalaryService;

import com.EmployeeManagement.SalaryService.FeignConfigEmployee;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryService {


    @Autowired
    SalaryDAO salaryDAO;

    @Autowired
    FeignConfigInsurance feignConfigInsurance;



    @Autowired
    FeignConfigEmployee feignConfigEmployee;

    public Salary createSalary(Salary salary) {
        return salaryDAO.save(salary);
    }

    public Iterable<Salary> getAllSalaries() {
        return salaryDAO.findAll();
    }

    public void deleteSalary(int salaryId) {
        salaryDAO.deleteById(salaryId);
    }

    public Salary getSalaryById(int salaryId) {

        String employee = feignConfigEmployee.getEmployeeNameById(salaryId);
        Insurance insurance = feignConfigInsurance.getInsuranceById(salaryId);
       Salary salary =  salaryDAO.findById(salaryId).get();
       salary.setEmployeeName(employee);
        salary.setInsurancePremium(insurance.getInsurancePremium());
        return salary;
    }
}
