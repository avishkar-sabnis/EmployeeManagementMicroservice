package com.EmployeeManagement.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/EmployeeManagement")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("/createEmployee/")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }


    @GetMapping("/ShowALlEmployees")

    public Iterable<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    int retryCount = 1;
    @GetMapping("/ShowEmployeeById/{employeeId}")
    //@CircuitBreaker(name = "employeeBreak" ,fallbackMethod = "fallbackIncaseOfFail")
    @Retry(name = "employeeBreakRetry",fallbackMethod = "fallbackIncaseOfRetry")
    public Employee getEmployeeById(@PathVariable int employeeId){
        System.out.println(retryCount);
        retryCount++;
        return employeeService.getEmployeeById(employeeId);
    }


    /*public Employee fallbackIncaseOfFail(Exception e){

        return new Employee(0,"NullAddress",0,0,"EmployeeNotExist");
    }*/

    public Employee fallbackIncaseOfRetry(Exception e){

        return  new Employee(0,"NullAddress",0,0,"EmployeeNotExist");
    }


    @GetMapping("/getEmployeeNameById/{employeeId}")
    public String getEmployeeNameById(@PathVariable int employeeId){
        return employeeService.getEmployeeNameById(employeeId);
    }

    @PutMapping("/updateEmployeeDetails/{employeeId}")
    public Employee updateEmployeeDetails(@RequestBody Employee newEmployeeData, @PathVariable int employeeId){
        return employeeService.updateEmployeeDetails(newEmployeeData,employeeId);
    }


    @DeleteMapping("/deleteEmployee/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
    }




}
