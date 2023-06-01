package com.solvd.carina.demo.gui.swaglabs.dao;

import com.solvd.carina.demo.gui.swaglabs.binary.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IUserDao extends IBaseDao<User> {
    @Override
    @Results({
            @Result(property = "idUser", column = "id_user"),
            @Result(property = "firstName", column = "fname"),
            @Result(property = "lastName", column = "lname"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "zipCode", column = "zip_code")
    })
    @Select("SELECT * FROM users c WHERE id_user = #{id}")
    User getEntityById(long id);
}
