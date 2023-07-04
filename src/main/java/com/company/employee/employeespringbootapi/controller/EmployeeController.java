package com.company.employee.employeespringbootapi.controller;

import com.company.employee.employeespringbootapi.entity.EmployeeBean;
import com.company.employee.employeespringbootapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
//    @Autowired
//    EmployeeService employeeService;

    @GetMapping (path = "/heart-beat")
    public String getEmployee(){
        return "New Employee";
    }

    @GetMapping (path = "/heart-beat-bean")
    public EmployeeBean getEmployeeBean(){
        return new EmployeeBean("New Employee");
    }

    @GetMapping (path = "/heart-beat-bean/path-variable/{id}")
    public EmployeeBean getEmployeeBeanPathVariable(@PathVariable int id){
        return new EmployeeBean(String.format("New Employee, %s", id));
    }

//    @GetMapping("/employee/{id}")
//    public String getEmployeeByID(@PathVariable String id) {
//        return employeeService.getEmployeeById(id);
//    }
}
