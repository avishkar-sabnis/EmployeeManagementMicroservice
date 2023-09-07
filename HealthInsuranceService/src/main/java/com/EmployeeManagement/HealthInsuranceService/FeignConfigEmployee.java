package com.EmployeeManagement.HealthInsuranceService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEESERVICE")
public interface FeignConfigEmployee {

    @GetMapping("/EmployeeManagement/ShowEmployeeById/{employeeId}")
    Employee getEmployeeById(@PathVariable int employeeId);


}
