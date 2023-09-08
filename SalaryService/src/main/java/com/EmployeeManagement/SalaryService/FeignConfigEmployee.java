package com.EmployeeManagement.SalaryService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEESERVICE")
public interface FeignConfigEmployee {

    @GetMapping("/EmployeeManagement/getEmployeeNameById/{employeeId}")
    String getEmployeeNameById(@PathVariable int employeeId);

}
