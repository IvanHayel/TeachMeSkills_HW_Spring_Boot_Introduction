package com.teachmeskills.spring_boot_introduction.model.service.user;

import com.teachmeskills.spring_boot_introduction.model.user.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(int id);
}