package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class PersonView extends RelativeLayout implements Checkable {

    public PersonView(Context context) {
        this(context, null);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    ImageView photoView,checkView,selectView;
    TextView nameView, ageView;

    boolean isChecked;

    @Override
    public void setChecked(boolean checked) {
        if(isChecked != checked) {
            isChecked = checked;
            drawCheck();
        }

    }

    private void drawCheck() {
        if(isChecked) {
            checkView.setImageResource(android.R.drawable.checkbox_on_background);
            selectView.setVisibility(View.VISIBLE);
        } else {
            checkView.setImageResource(android.R.drawable.checkbox_off_background);
            selectView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(isChecked);


    }

    public interface OnImageClickListener {
        public void onImageClick(PersonView view, Person person);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mListener = listener;
    }

    private void init(AttributeSet attrs) {

        /*LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_person, this);*/
        inflate(getContext(), R.layout.view_person, this); // 위 2줄과 같은 표현
        photoView = (ImageView) findViewById(R.id.image_photo);
        checkView = (ImageView) findViewById(R.id.image_check);
        selectView = (ImageView) findViewById(R.id.image_select);
        nameView = (TextView) findViewById(R.id.text_name);
        ageView = (TextView) findViewById(R.id.text_age);
        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    mListener.onImageClick(PersonView.this, person);
                }
            }
        });
        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.PersonView);
            String name = ta.getString(R.styleable.PersonView_my_name);
            Person p = new Person();
            if (!TextUtils.isEmpty(name)) {
                nameView.setText(name);
                p.setName(name);
                person = p;
            }
            int age = ta.getInt(R.styleable.PersonView_my_age, -1);
            if (age != -1) {
                ageView.setText("" + age);
                p.setAge(age);
                person  = p;
            }

            Drawable d = ta.getDrawable(R.styleable.PersonView_my_photo);
            if (d != null) {
                photoView.setImageDrawable(d);
                p.setPhoto(d);
                person = p;
            }
            ta.recycle();
        }
    }

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        nameView.setText(person.getName());
        ageView.setText("" + person.getAge());
        photoView.setImageDrawable(person.getPhoto());


    }

    public Person getPerson() {
        return person;
    }
}
