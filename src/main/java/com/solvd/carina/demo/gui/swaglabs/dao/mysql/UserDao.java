package com.solvd.carina.demo.gui.swaglabs.dao.mysql;

import com.solvd.carina.demo.gui.swaglabs.binary.User;
import com.solvd.carina.demo.gui.swaglabs.dao.IUserDao;
import com.solvd.carina.demo.gui.swaglabs.dao.utils.MyBatisDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements IUserDao {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDao.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);

    @Override
    public User getEntityById(long id) {
        return iUserDao.getEntityById(id);
    }
}
