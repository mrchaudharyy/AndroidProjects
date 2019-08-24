package com.example.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Global");
        mDatabase.keepSynced(true);

        mBlogList = findViewById(R.id.myRecyclerView);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<DataModel, DataViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<DataModel, DataViewHolder>
                (DataModel.class, R.layout.data_row, DataViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(DataViewHolder viewHolder, DataModel model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(), model.getImage());
            }
        };
        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }
}
