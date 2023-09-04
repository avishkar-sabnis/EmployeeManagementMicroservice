package com.EmployeeManagement.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    @Autowired
    EmployeeDAO employeeDAO;

    public Employee createEmployee(Employee employee) {
        return employeeDAO.save(employee);

    }

    public Iterable<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeDAO.findById(employeeId).get();
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
