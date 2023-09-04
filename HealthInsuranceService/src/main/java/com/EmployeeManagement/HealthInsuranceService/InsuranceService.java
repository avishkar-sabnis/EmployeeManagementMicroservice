package com.EmployeeManagement.HealthInsuranceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsuranceService {


    @Autowired
    InsuranceDAO insuranceDAO;



    public Insurance createInsuranceScheme(Insurance insurance) {
        return insuranceDAO.save(insurance);
    }

    public Iterable<Insurance> getAllInsuranceSchemes() {
        return insuranceDAO.findAll();
    }

    public Optional<Insurance> getInsuranceById(int insuranceId) {
        return insuranceDAO.findById(insuranceId);
    }

    public void deleteInsurance(int employeeId) {
        insuranceDAO.deleteById(employeeId);
    }
}
