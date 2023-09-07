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
@AllArgsConstructor
@Table(name = "SalaryManagement")
public class Salary {

    @Id
    @Column(name = "salaryId")
    int salaryId;

    @Transient
    String EmployeeName;

    @Column(name = "EmployeeSalary")
    double EmployeeSalary;

    @Transient
    double InsurancePremium;


}
