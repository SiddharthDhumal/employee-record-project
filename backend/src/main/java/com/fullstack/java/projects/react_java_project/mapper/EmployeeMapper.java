package com.fullstack.java.projects.react_java_project.mapper;

import com.fullstack.java.projects.react_java_project.dto.EmployeeDto;
import com.fullstack.java.projects.react_java_project.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
         return new EmployeeDto(
                 employee.getId(),
                 employee.getFirstName(),
                 employee.getLastName(),
                 employee.getEmail()
         );
    };

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}