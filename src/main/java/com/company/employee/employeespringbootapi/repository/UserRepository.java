package com.company.employee.employeespringbootapi.repository;

import com.company.employee.employeespringbootapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
