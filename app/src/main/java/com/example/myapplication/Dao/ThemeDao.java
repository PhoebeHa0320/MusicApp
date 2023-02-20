package com.example.myapplication.Dao;

import com.example.myapplication.Dao.Listeners.RetrieValEventListener;
import com.example.myapplication.Dao.Listeners.TaskListener;
import com.example.myapplication.Model.Album;
import com.example.myapplication.Model.Theme;
import com.google.firebase.database.DataSnapshot;

import java.util.List;

public class ThemeDao extends FirebaseDao<Theme> implements IThemeDao{
    public ThemeDao(){
        // Specify the table name for the class
        super("theme");
    }
    @Override
    public String getNewKey() {
        return super.getNewKey();
    }

    @Override
    public void getAll(RetrieValEventListener<List<Theme>> retrievalEventListener) {
        super.getAll(retrievalEventListener);
    }

    @Override
    public void get(String id, RetrieValEventListener<Theme> retrievalEventListener) {
        super.get(id, retrievalEventListener);
    }

    @Override
    public void save(Theme theme, String id, TaskListener taskListener) {
        super.save(theme, id, taskListener);
    }

    @Override
    public void delete(String id, TaskListener taskListener) {
        super.delete(id, taskListener);
    }

    @Override
    protected void parseDataSnapshot(DataSnapshot dataSnapshot, RetrieValEventListener<Theme> retrievalEventListener) {
        // Create a new Theme object to populate data
        final Theme theme = new Theme();
        theme.key = dataSnapshot.getKey();
        //  ----------------------------------------------------------------------------------------
        // | IMPORTANT NOTE: make sure that the variable name is EXACTLY the same as the node name. |
        //  ----------------------------------------------------------------------------------------
        //       ↓                           ↓
        theme.setId(dataSnapshot.child("id").getValue().toString());
        //       ↓                           ↓
        theme.setImage(dataSnapshot.child("image").getValue().toString());
        //       ↓                           ↓
        theme.setName(dataSnapshot.child("name").getValue().toString());

        // Now we have parsed all of the attributes of the theme object. We will feed it to the callback
        retrievalEventListener.OnDataRetrieved(theme);
    }
}
