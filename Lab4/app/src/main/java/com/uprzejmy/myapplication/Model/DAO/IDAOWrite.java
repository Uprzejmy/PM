package com.uprzejmy.myapplication.Model.DAO;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public interface IDAOWrite<T>
{
    void add(T item);
    void update(T item);
    void remove(T item);
}
