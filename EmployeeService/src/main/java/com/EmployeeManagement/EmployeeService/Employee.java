package com.EmployeeManagement.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "EmployeeManagement")
public class Employee {

    @Id
    @Column(name = "EmployeeId")
    int EmployeeId;

    @Column(name = "EmployeeName")
    String employeeName;

    @Transient
    double EmployeeSalary;
    @Transient
    double InsurancePremium;

    @Column(name = "EmployeeDesignation")
    String EmployeeDesignation;

    public Employee(int employeeId, String eemployeeName, double employeeSalary, double insurancePremium, String employeeDesignation) {
        EmployeeId = employeeId;
        employeeName = eemployeeName;
        EmployeeSalary = employeeSalary;
        InsurancePremium = insurancePremium;
        EmployeeDesignation = employeeDesignation;
    }
}
