package com.EmployeeManagement.SalaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/SalaryManagement")
public class SalaryController {

    @Autowired
    SalaryService salaryService;


    @PostMapping("/createSalaryDetails/")
    public Salary createSalary(@RequestBody Salary salary){
        return salaryService.createSalary(salary);
    }

    @GetMapping("/ShowALlSalaries")
    public Iterable<Salary> getAllSalaries(){
        return salaryService.getAllSalaries();
    }

    @GetMapping("/getSalaryById/{salaryId}")
    public Salary getSalaryById(@PathVariable int salaryId){
        return salaryService.getSalaryById(salaryId);
    }




    @DeleteMapping("/deleteSalary/{salaryId}")
    public void deleteEmployee(@PathVariable int salaryId){
        salaryService.deleteSalary(salaryId);
    }




}
