package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Actor;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class ActorInfoView extends FrameLayout {

    public ActorInfoView(Context context) {
        super(context);
        init();

    }

    ImageView photoView;
    TextView nameView, ageView, descView;

    private void init() {
        inflate(getContext(), R.layout.view_actor_info, this);
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
        descView = (TextView)findViewById(R.id.text_description);

    }

    Actor actor;
    public void setActor(Actor actor){
        this.actor = actor;
        photoView.setImageDrawable(actor.photo);
        nameView.setText(actor.name);
        ageView.setText(""+actor.age);
        descView.setText(actor.description);

    }




}
