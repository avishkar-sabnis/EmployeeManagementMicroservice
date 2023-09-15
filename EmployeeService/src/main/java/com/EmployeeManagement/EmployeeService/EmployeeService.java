package com.EmployeeManagement.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee createEmployee(Employee employee) {
        return employeeDAO.save(employee);

    }

    public List<Employee> getAllEmployees() {


        List list = new ArrayList<>();
        long countOfEmployees = getAllEmployeesIds();
        int count = (int) countOfEmployees;
        for(int i=1;i<=count;i++){

            list .add(getEmployeeById(i));
        }
        System.out.println(list);
        return list;

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
    public String getEmployeeNameById(int employeeId){
        Employee employees ;
        employees = employeeDAO.findById(employeeId).get();

        return employees.getEmployeeName();
    }

    public void deleteEmployee(int employeeId) {

         employeeDAO.deleteById(employeeId);
    }


    public long getAllEmployeesIds(){
        System.out.println(employeeDAO.findByemployeeNameIsNotNull().stream().count());
        return employeeDAO.findByemployeeNameIsNotNull().stream().count();
    }
}
