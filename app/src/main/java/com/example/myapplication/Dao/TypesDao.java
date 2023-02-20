package com.example.myapplication.Dao;

import com.example.myapplication.Dao.Listeners.RetrieValEventListener;
import com.example.myapplication.Dao.Listeners.TaskListener;
import com.example.myapplication.Model.Theme;
import com.example.myapplication.Model.Types;
import com.google.firebase.database.DataSnapshot;

import java.util.List;

public class TypesDao extends FirebaseDao<Types> implements ITypesDAO {
    public TypesDao(){
        // Specify the table name for the class
        super("types");
    }
    @Override
    public String getNewKey() {
        return super.getNewKey();
    }

    @Override
    public void getAll(RetrieValEventListener<List<Types>> retrievalEventListener) {
        super.getAll(retrievalEventListener);
    }

    @Override
    public void get(String id, RetrieValEventListener<Types> retrievalEventListener) {
        super.get(id, retrievalEventListener);
    }

    @Override
    public void save(Types types, String id, TaskListener taskListener) {
        super.save(types, id, taskListener);
    }

    @Override
    public void delete(String id, TaskListener taskListener) {
        super.delete(id, taskListener);
    }

    @Override
    protected void parseDataSnapshot(DataSnapshot dataSnapshot, RetrieValEventListener<Types> retrievalEventListener) {
        // Create a new Types object to populate data
        final Types types = new Types();
        types.key = dataSnapshot.getKey();
        //  ----------------------------------------------------------------------------------------
        // | IMPORTANT NOTE: make sure that the variable name is EXACTLY the same as the node name. |
        //  ----------------------------------------------------------------------------------------
        //       ↓                           ↓
        types.setId(dataSnapshot.child("id").getValue().toString());
        //       ↓                           ↓
        types.setImage(dataSnapshot.child("image").getValue().toString());
        //       ↓                           ↓
        types.setName(dataSnapshot.child("name").getValue().toString());

        // Now we have parsed all of the attributes of the types object. We will feed it to the callback
        retrievalEventListener.OnDataRetrieved(types);
    }
}

