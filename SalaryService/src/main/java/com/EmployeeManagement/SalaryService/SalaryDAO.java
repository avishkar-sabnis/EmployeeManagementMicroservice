package com.EmployeeManagement.SalaryService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryDAO extends JpaRepository<Salary,Integer> {


}
