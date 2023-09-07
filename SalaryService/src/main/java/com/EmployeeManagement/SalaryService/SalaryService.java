package com.EmployeeManagement.SalaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryService {


    @Autowired
    SalaryDAO salaryDAO;


    public Salary createSalary(Salary salary) {
        return salaryDAO.save(salary);
    }

    public Iterable<Salary> getAllSalaries() {
        return salaryDAO.findAll();
    }

    public void deleteSalary(int salaryId) {
        salaryDAO.deleteById(salaryId);
    }

    public Optional<Salary> getSalaryById(int salaryId) {
       return salaryDAO.findById(salaryId);
    }
}
