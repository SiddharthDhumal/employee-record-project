package com.fullstack.java.projects.react_java_project.repository;

import com.fullstack.java.projects.react_java_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
