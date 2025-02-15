package com.springproject.ems.service.impl;

import com.springproject.ems.dto.EmployeeDto;
import com.springproject.ems.entity.Employee;
import com.springproject.ems.mapper.EmployeeMapper;
import com.springproject.ems.repository.EmployeeRepository;
import com.springproject.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
