package com.fullstack.java.projects.react_java_project.service.impl;


import com.fullstack.java.projects.react_java_project.dto.EmployeeDto;
import com.fullstack.java.projects.react_java_project.entity.Employee;
import com.fullstack.java.projects.react_java_project.exception.ResourceNotFoundException;
import com.fullstack.java.projects.react_java_project.mapper.EmployeeMapper;
import com.fullstack.java.projects.react_java_project.repository.EmployeeRepository;
import com.fullstack.java.projects.react_java_project.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
          Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                  () -> new ResolutionException("Employee Does not exists with given Id :" + employeeId)
          );

          return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
       return employeeList.stream().map(EmployeeMapper::mapToEmployeeDto
        ).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not found with given Id : " + employeeId)
        );

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not found with given Id : " + employeeId)
        );

       employeeRepository.deleteById(employeeId);
    }
}
