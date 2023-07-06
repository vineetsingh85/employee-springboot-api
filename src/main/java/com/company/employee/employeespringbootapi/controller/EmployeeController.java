package com.company.employee.employeespringbootapi.controller;

import com.company.employee.employeespringbootapi.entity.EmployeeBean;
import com.company.employee.employeespringbootapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class EmployeeController {
//    @Autowired
//    EmployeeService employeeService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping (path = "/hello-world-intl")
    public String getEmployee(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.world.message", null, "Default Message", locale);
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
