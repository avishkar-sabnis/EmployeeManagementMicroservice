package com.EmployeeManagement.SalaryService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryDAO extends CrudRepository<Salary,Integer> {


}
