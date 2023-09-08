package com.EmployeeManagement.SalaryService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "INSURANCEMANAGEMENT")
public interface FeignConfigInsurance {




    @GetMapping("/InsuranceManagement/ShowInsuranceById/{insuranceId}")
    Insurance getInsuranceById(@PathVariable int insuranceId);


}