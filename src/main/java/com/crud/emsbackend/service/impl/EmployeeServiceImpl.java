package com.crud.emsbackend.service.impl;

import com.crud.emsbackend.dto.EmployeeDto;
import com.crud.emsbackend.entity.Employee;
import com.crud.emsbackend.exception.ResourceNotFoundException;
import com.crud.emsbackend.mapper.EmployeeMapper;
import com.crud.emsbackend.repository.EmployeeRepository;
import com.crud.emsbackend.service.EmployeeService;
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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

}
