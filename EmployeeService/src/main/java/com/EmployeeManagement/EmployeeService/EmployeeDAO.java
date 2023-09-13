package com.EmployeeManagement.EmployeeService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

    public List<Employee> findByemployeeNameIsNotNull();

}
