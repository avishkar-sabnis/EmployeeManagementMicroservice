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
@Table(name = "InsuranceManagement")
public class Insurance {

    @Id
    @Column(name = "InsuranceId")
    int InsuranceId;

    @Column(name = "InsuranceName")
    String InsuranceName;


    @Transient
    String EmployeeName;


    @Column(name = "InsurancePremiumAmt")
    double InsurancePremium;

}
