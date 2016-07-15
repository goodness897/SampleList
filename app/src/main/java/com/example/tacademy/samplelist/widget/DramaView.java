package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Drama;


/**
 * Created by Administrator on 2016-07-15.
 */
public class DramaView extends RelativeLayout {
    public DramaView(Context context) {
        super(context);
        init();
    }

    ImageView pictureView;
    TextView titleView, intervalView;
    private void init() {
        inflate(getContext(), R.layout.view_drama, this);
        pictureView = (ImageView)findViewById(R.id.image_picture);
        titleView = (TextView)findViewById(R.id.text_title);
        intervalView = (TextView)findViewById(R.id.text_interval);
    }

    Drama drama;
    public void setDrama(Drama drama) {
        this.drama = drama;
        pictureView.setImageDrawable(drama.picture);
        titleView.setText(drama.title);
        intervalView.setText(drama.interval);
    }

    public Drama getDrama() {
        return drama;
    }
}
