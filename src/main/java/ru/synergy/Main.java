package ru.synergy;

import ru.synergy.models.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getUsers();
        System.out.println(users);
    }
}