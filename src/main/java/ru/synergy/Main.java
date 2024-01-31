package ru.synergy;

import ru.synergy.dao.UserDao_JPA;
import ru.synergy.models.Contact;
import ru.synergy.models.User;
import ru.synergy.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user_1 = new User("Petya");
        User user_2 = new User("Vasya");
        User user_3 = new User("Katya");
        Contact contact_1 = new Contact(user_1, "first", "1234567", "email@lll.ru");
        Contact contact_2 = new Contact(user_1, "second", "456756756", "sefefrfrt@lll.ru");
        Contact contact_3 = new Contact(user_3, "main", "1234565", "herhhwwh@lll.ru");
        user_1.setContacts(List.of(contact_1, contact_2));
        user_3.setContacts(List.of(contact_3));

        UserDao_JPA userDaoJPA = new UserDao_JPA();
//        UserDao_Hiber userDaoHiber = new UserDao_Hiber();
        UserService userService = new UserService(userDaoJPA);
        userService.saveUser(user_1);
        userService.saveUser(user_2);
        userService.saveUser(user_3);

        List<User> users = userService.findAllUsers();
        System.out.println(users);

        User user = userService.findUser(1);
        user.setName("Vladimir");
        userService.updateUser(user);

        User userD = userService.findUser(3);
        userService.deleteUser(userD);
    }
}