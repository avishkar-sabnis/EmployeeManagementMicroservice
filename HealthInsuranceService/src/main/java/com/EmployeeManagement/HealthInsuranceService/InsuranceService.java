package com.EmployeeManagement.HealthInsuranceService;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsuranceService {


    @Autowired
    InsuranceDAO insuranceDAO;

   @Autowired
   FeignConfigEmployee feignConfigEmployee;

    public Insurance createInsuranceScheme(Insurance insurance) {
        return insuranceDAO.save(insurance);
    }

    public Iterable<Insurance> getAllInsuranceSchemes() {
        return insuranceDAO.findAll();
    }

    public Insurance getInsuranceById(int insuranceId) {


        //Employee employee = feignConfigEmployee.getEmployeeById(insuranceId);
        Insurance insurance = insuranceDAO.findById(insuranceId).get();
        //insurance.setEmployeeName(employee.getEmployeeName());
        return insurance;






    }

    public void deleteInsurance(int employeeId) {
        insuranceDAO.deleteById(employeeId);
    }
}
