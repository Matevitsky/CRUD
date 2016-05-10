package ru.matevitsky.crud.dao;

import javassist.bytecode.stackmap.TypeData;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import ru.matevitsky.crud.domain.User;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Sergey on 13.04.16.
 */
public class userDaoImpl implements UserDao {
    private static final Logger log= Logger.getLogger( TypeData.ClassName.class.getName() );
    private static int pageSize = 4;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List searchUser(String name)
    {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User");
        query = query.setFirstResult(pageSize * (10000 - 1));
        query.setMaxResults(pageSize);
        @SuppressWarnings("unchecked")
        List<User> userList = query.list();

        List<User> tempList = new ArrayList<>();

        for (int i = 0; i < userList.size() ; i++) {
            if(userList.get(i).getName().equals(name)) {
                tempList.add(userList.get(i));
            }
        }
        session.close();
        return tempList;
    }

    public int addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        user.setCreatedDate(new Timestamp(new Date().getTime()));
        session.save(user);
        tx.commit();
        Serializable id = session.getIdentifier(user);
        session.close();
        log.info("User was added successfully");
        return (Integer) id;

    }

    @Override
    public List<User> getList(int pageNumber) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User");
        query = query.setFirstResult(pageSize * (pageNumber - 1));
        query.setMaxResults(pageSize);
        @SuppressWarnings("unchecked")
        List<User> userList = query.list();

        session.close();
        return userList;
    }

    @Override
    public List<User> getList(int pageNumber, String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select * from User where name like :name").addEntity(User.class);
        query.setString("name", name);
        query = query.setFirstResult(pageSize * (pageNumber - 1));
        query.setMaxResults(pageSize);
        @SuppressWarnings("unchecked")
        List<User> userList = query.list();

        session.close();
        return userList;
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.openSession();
        // User user = (User) session.load(User.class, id);
        User user = (User) session.get(User.class, id);
        return user;
    }


    public int updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        // session.update(user);
        tx.commit();
        Serializable id = session.getIdentifier(user);
        session.close();
        return (Integer) id;
    }


    public int removeUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = (User) session.load(User.class, id);
        session.delete(user);
        tx.commit();
        Serializable ids = session.getIdentifier(user);
        session.close();
        return (Integer) ids;
    }


}
