package com.uprzejmy.myapplication.Model.DAO;

import java.util.List;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public interface IDAORead<T>
{
    T findById(int id);
    List<T> findAll();
}
