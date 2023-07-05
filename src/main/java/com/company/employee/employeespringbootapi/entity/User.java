package com.company.employee.employeespringbootapi.entity;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter @Setter
public class User {
    private Integer id;

    @Size (min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Past (message = "Birth date should always be in the past")
    private LocalDate birthDate;
}
