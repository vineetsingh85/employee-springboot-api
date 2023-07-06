package com.company.employee.employeespringbootapi.repository;

import com.company.employee.employeespringbootapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
