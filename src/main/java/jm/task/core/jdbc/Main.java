package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        UserServiceImpl u = new UserServiceImpl();
//        u.createUsersTable();
//        u.createUsersTable();
        u.dropUsersTable();
        u.dropUsersTable();

//        UserServiceImpl u = new UserServiceImpl();
//        for (User user : u.getAllUsers()) {
//            System.out.println(user);
//        }
//        u.saveUser("ivan","ivanov", 12);
//        for (User user : u.getAllUsers()) {
//            System.out.println(user);
//        }
    }
}
