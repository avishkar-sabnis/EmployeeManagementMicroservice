package com.EmployeeManagement.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    FeignConfigInsurance feignConfigInsurance;
    @Autowired
    FeignConfig feignConfig;

    @Autowired
    RestTemplate restTemplate;

    public Employee createEmployee(Employee employee) {
        return employeeDAO.save(employee);

    }

    public Iterable<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public Employee getEmployeeById(int employeeId) {


        Salary salary =  feignConfig.getSalaryById(employeeId);
        Insurance insurance = feignConfigInsurance.getInsuranceById(employeeId);
        Employee employee = employeeDAO.findById(employeeId).get();
        employee.setEmployeeSalary(salary.getEmployeeSalary());
        employee.setInsurancePremium(insurance.getInsurancePremium());

        return employee;
    }

    public Employee updateEmployeeDetails(Employee newEmployeeData,int employeeId) {
        Employee employee = new Employee();
        if(employeeId == newEmployeeData.getEmployeeId()){
            employee.setEmployeeId(newEmployeeData.getEmployeeId());
            employee.setEmployeeName(newEmployeeData.getEmployeeName());
            employee.setEmployeeSalary(newEmployeeData.getEmployeeSalary());
            employee.setEmployeeDesignation(newEmployeeData.getEmployeeDesignation());
            return employeeDAO.save(employee);
        }
        else{
            return null;
        }

    }

    public void deleteEmployee(int employeeId) {

         employeeDAO.deleteById(employeeId);
    }
}
