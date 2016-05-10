package ru.matevitsky.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.matevitsky.crud.dao.UserDao;
import ru.matevitsky.crud.domain.User;

import java.util.List;

/**
 * Created by Sergey on 13.04.16.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List searchUser(String name){
        return userDao.searchUser(name);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getList(int pageNumber) {
        return userDao.getList(pageNumber);
    }

    @Override
    public List<User> getList(int pageNumber, String name) {
        return userDao.getList(pageNumber, name);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int removeUser(int id) {
        return userDao.removeUser(id);
    }

}
