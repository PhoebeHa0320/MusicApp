package com.example.myapplication.Dao;

import com.example.myapplication.Dao.Listeners.RetrieValEventListener;
import com.example.myapplication.Dao.Listeners.TaskListener;
import com.example.myapplication.Model.Types;

import java.util.List;

public interface ITypesDAO {
    String getNewKey();
    void get(String id, final RetrieValEventListener<Types> retrievalEventListener);
    void getAll(final RetrieValEventListener<List<Types>> retrievalEventListener);
    void save(Types types, String id, final TaskListener taskListener);
    void delete(String id, TaskListener taskListener);
}
