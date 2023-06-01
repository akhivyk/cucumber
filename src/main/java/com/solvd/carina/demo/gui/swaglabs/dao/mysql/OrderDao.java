package com.solvd.carina.demo.gui.swaglabs.dao.mysql;

import com.solvd.carina.demo.gui.swaglabs.binary.Order;
import com.solvd.carina.demo.gui.swaglabs.dao.IOrderDao;
import com.solvd.carina.demo.gui.swaglabs.dao.utils.MyBatisDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderDao implements IOrderDao {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDao.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final IOrderDao iOrderDao = sqlSession.getMapper(IOrderDao.class);

    @Override
    public Order getEntityById(long id) {
        return iOrderDao.getEntityById(id);
    }

    @Override
    public List<Order> getOrdersByUserId(long idUser) {
        return iOrderDao.getOrdersByUserId(idUser);
    }
}
