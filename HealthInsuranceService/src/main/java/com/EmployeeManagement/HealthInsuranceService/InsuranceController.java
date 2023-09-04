package com.EmployeeManagement.HealthInsuranceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/InsuranceManagement")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;


    @PostMapping("/createInsuranceScheme/")
    public Insurance createInsuranceScheme(@RequestBody Insurance insurance){
        return insuranceService.createInsuranceScheme(insurance);
    }

    @GetMapping("/ShowALlInsuranceSchemes")
    public Iterable<Insurance> getAllInsuranceSchemes(){
        return insuranceService.getAllInsuranceSchemes();
    }

    @GetMapping("/ShowInsuranceById/{insuranceId}")
    public Optional<Insurance> getInsuranceById(@PathVariable int insuranceId){
        return insuranceService.getInsuranceById(insuranceId);
    }



    @DeleteMapping("/deleteInsurance/{insuranceId}")
    public void deleteEmployee(@PathVariable int insuranceId){
        insuranceService.deleteInsurance(insuranceId);
    }




}
