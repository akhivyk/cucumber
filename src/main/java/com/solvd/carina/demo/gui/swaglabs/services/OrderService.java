package com.solvd.carina.demo.gui.swaglabs.services;

import com.solvd.carina.demo.gui.swaglabs.binary.Order;
import com.solvd.carina.demo.gui.swaglabs.dao.IOrderDao;
import com.solvd.carina.demo.gui.swaglabs.dao.mysql.OrderDao;

import java.util.List;

public class OrderService {
    private static final IOrderDao ORDER_DAO = new OrderDao();

    public static List<Order> getUserOrders(long id_user) {
        return ORDER_DAO.getOrdersByUserId(id_user);
    }
}
