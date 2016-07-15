package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.tacademy.samplelist.data.Person;

import java.util.Random;

public class RecyclerActivity extends AppCompatActivity {
    
    RecyclerView listView;
    RecyclerPersonAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        
        listView = (RecyclerView)findViewById(R.id.rv_list);
        mAdapter = new RecyclerPersonAdapter();
        mAdapter.setOnAdapterItemClickListener(new RecyclerPersonAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemClick(View view, Person person, int position) {
                Toast.makeText(RecyclerActivity.this, "person : " + person.getName(), Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(mAdapter);
        /*
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listView.setLayoutManager(manager);*/

        GridLayoutManager manager =
                new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        listView.setLayoutManager(manager);

        initData();
    }

    int[] resIds = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2};

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            Person p = new Person();
            p.setName("name " + i);
            p.setAge(20 + r.nextInt(30));
            p.setPhoto(ContextCompat.getDrawable(this, resIds[i % resIds.length]));
            mAdapter.add(p);
        }
    }
}
