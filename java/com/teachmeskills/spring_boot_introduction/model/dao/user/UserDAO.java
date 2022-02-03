package com.teachmeskills.spring_boot_introduction.model.dao.user;

import com.teachmeskills.spring_boot_introduction.model.user.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User getUser(int id);
}
