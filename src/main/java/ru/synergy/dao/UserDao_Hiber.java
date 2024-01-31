package ru.synergy.dao;

import org.hibernate.Transaction;
import ru.synergy.hiber.Session;
import ru.synergy.models.User;

import java.util.List;

public class UserDao_Hiber implements UserDao{
    @Override
    public User findById(int id) {return Session.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public void save(User user) {
        var session = Session.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        var session = Session.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.detach(user);
        session.merge(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        var session = Session.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(session.get(User.class, user.getId()));
        session.flush();
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        return Session.getSessionFactory().openSession().createQuery("from User", User.class).list();
    }





}
