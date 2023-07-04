package com.company.employee.employeespringbootapi.service;

import com.company.employee.employeespringbootapi.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

//    @Autowired
//    private final EmployeeRepository employeeRepository;
//
//    @Cacheable(value = "itemCache")
//    public String getEmployeeById(String id) {
//        return employeeRepository.findById(id)
//                .orElseThrow(RuntimeException::new);
//    }

}

