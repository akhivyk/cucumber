package com.solvd.carina.demo.gui.swaglabs.dao;

import com.solvd.carina.demo.gui.swaglabs.binary.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderDao extends IBaseDao<Order> {
    @Override
    @Results({
            @Result(property = "idOrder", column = "id_order"),
            @Result(property = "idUser", column = "user_id"),
            @Result(property = "item", column = "item")
    })
    @Select("SELECT * FROM orders c WHERE id_order = #{id}")
    Order getEntityById(long id);

    @Results({
            @Result(property = "idOrder", column = "id_order"),
            @Result(property = "idUser", column = "user_id"),
            @Result(property = "item", column = "item")
    })
    @Select("SELECT * FROM orders c WHERE user_id = #{idUser}")
    List<Order> getOrdersByUserId(long idUser);
}
