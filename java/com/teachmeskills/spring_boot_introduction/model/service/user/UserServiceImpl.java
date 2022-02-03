package com.teachmeskills.spring_boot_introduction.model.service.user;

import com.teachmeskills.spring_boot_introduction.model.dao.user.UserDAO;
import com.teachmeskills.spring_boot_introduction.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUser(int id){
        return userDAO.getUser(id);
    }
}