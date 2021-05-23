package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoHibernateImpl() {
        sessionFactory = Util.getSessionFactory();
    }


    @Override
    public void createUsersTable() {

        try(Session session = sessionFactory.openSession()) {
            Transaction tx= session.beginTransaction();
            Query query= session.createSQLQuery("CREATE TABLE users (id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(40), lastName VARCHAR(40), age INT);");
            query.executeUpdate();

            tx.commit();

        } catch (Exception e) {
            System.out.println("Catch при создании таблицы");
        }
    }

    @Override
    public void dropUsersTable() {

        try (Session session = sessionFactory.openSession();){
            Transaction tx= session.beginTransaction();
            Query query= session.createSQLQuery("DROP TABLE users");
            query.executeUpdate();

            tx.commit();
        } catch (Exception e) {
            System.out.println("Catch при удалении таблицы");
        }
    }

    @Override
    public void saveUser(String name, String lastName, Integer age) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(new User(name, lastName, age));
        tx1.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(sessionFactory.openSession().get(User.class, id));
        tx1.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> author = (List<User>)  sessionFactory.openSession().createQuery("From User").list();
        return author;
    }

    @Override
    public void cleanUsersTable() {
        for (User element : getAllUsers()) {
            delete(element);
        }
    }

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
