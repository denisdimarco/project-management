package com.ddm.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ddm.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
