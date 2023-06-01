package com.solvd.carina.demo.gui.swaglabs.dao;

public interface IBaseDao<T> {
    T getEntityById(long id);
}
