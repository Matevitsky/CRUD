package ru.matevitsky.crud.service;

import ru.matevitsky.crud.domain.User;

import java.util.List;

/**
 * Created by Sergey on 13.04.16.
 */
public interface UserService {
    public List searchUser(String name);

    public int addUser(User user);

    public List<User> getList(int pageNumber);

    public List<User> getList(int pageNumber, String name);

    public User getUser(int id);

    public int updateUser(User user);

    public int removeUser(int id);

}
