package com.example.tacademy.samplelist;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.tacademy.samplelist.data.Person;
import com.example.tacademy.samplelist.widget.PersonView;

public class MainActivity extends AppCompatActivity {

    PersonView personView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personView = (PersonView) findViewById(R.id.view_person);
        initData();

    }

    private void initData() {

        Drawable photo = ContextCompat.getDrawable(this, R.drawable.sample_0);
        Person p = new Person("pms", 28, photo);
        personView.setPerson(p);


    }
}
