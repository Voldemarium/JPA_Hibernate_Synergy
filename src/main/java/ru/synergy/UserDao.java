package ru.synergy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.synergy.models.User;

import java.util.List;

public class UserDao {
    private final SessionFactory sessionFactory;

    public UserDao() {
        Configuration configuration = new Configuration()
                .configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void createDDL(String queryDDL) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery(queryDDL).executeUpdate();
            transaction.commit();
        }
    }

//    //    Получение списка всех контактов
//    public List<Contact> getContacts() {
//        Session session = sessionFactory.openSession();
//        List<Contact> contacts = session.createQuery("from Contacts", Contact.class).list();
//        session.close();
//        return contacts;
//    }

    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User", User.class).list();
        session.close();
        return users;
    }
}
