package com.example.myapplication.Dao;

import com.example.myapplication.Dao.Listeners.RetrieValEventListener;
import com.example.myapplication.Dao.Listeners.TaskListener;
import com.example.myapplication.Model.Theme;

import java.util.List;

public interface IThemeDao {
    String getNewKey();
    void get(String id, final RetrieValEventListener<Theme> retrievalEventListener);
    void getAll(final RetrieValEventListener<List<Theme>> retrievalEventListener);
    void save(Theme theme, String id, final TaskListener taskListener);
    void delete(String id, TaskListener taskListener);
}
