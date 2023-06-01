package com.solvd.carina.demo.gui.swaglabs.services;

import com.solvd.carina.demo.gui.swaglabs.binary.User;
import com.solvd.carina.demo.gui.swaglabs.dao.IUserDao;
import com.solvd.carina.demo.gui.swaglabs.dao.mysql.UserDao;

public class UserService {
    private static final IUserDao USER_DAO = new UserDao();

    public static User getUser(long id_user) {
        return USER_DAO.getEntityById(id_user);
    }
}
