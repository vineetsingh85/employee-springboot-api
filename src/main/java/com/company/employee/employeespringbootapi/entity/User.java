package com.company.employee.employeespringbootapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
@Entity(name="user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size (min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Past (message = "Birth date should always be in the past")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")

    @JsonIgnore
    private List<Post> posts;
}
