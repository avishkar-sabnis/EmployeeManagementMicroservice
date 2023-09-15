package com.EmployeeManagement.SalaryService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SalaryManagement")
public class Salary {

    @Id
    @Column(name = "salaryId")
    int salaryId;

    @Transient
    String EmployeeName;

    public Salary(int salaryId, String employeeName, double employeeSalary, double insurancePremium) {
        this.salaryId = salaryId;
        EmployeeName = employeeName;
        EmployeeSalary = employeeSalary;
        InsurancePremium = insurancePremium;
    }

    @Column(name = "EmployeeSalary")
    double EmployeeSalary;

    @Transient
    double InsurancePremium;


}
