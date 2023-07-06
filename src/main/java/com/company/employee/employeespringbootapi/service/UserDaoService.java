package com.company.employee.employeespringbootapi.service;

import com.company.employee.employeespringbootapi.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;


    static{
        users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(30), null));
        users.add(new User(++usersCount,"Eve", LocalDate.now().minusYears(25), null));
        users.add(new User(++usersCount,"Jim", LocalDate.now().minusYears(20), null));
    }

    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;

    }

    public void deleteUserById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
