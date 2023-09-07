package com.EmployeeManagement.HealthInsuranceService;

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
@Table(name = "EmployeeManagement")
public class Employee {

    @Id
    @Column(name = "EmployeeId")
    int EmployeeId;

    @Column(name = "EmployeeName")
    String EmployeeName;

    @Transient
    double EmployeeSalary;
    @Transient
    double InsurancePremium;

    @Column(name = "EmployeeDesignation")
    String EmployeeDesignation;
}
