package com.example.tacademy.samplelist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class PersonViewHolder extends RecyclerView.ViewHolder {

    ImageView photoView;
    TextView nameView, ageView;

    public interface OnPersonItemClickListener {
        public void onPersonItemClick(View view, Person person, int position);

    }

    OnPersonItemClickListener listener;
    public void setOnPersonItemClickListener(OnPersonItemClickListener listener){
        this.listener = listener;
    }


    public PersonViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onPersonItemClick(view, person, getAdapterPosition()); // 데이터 상의 position을 사용할 것이기 때문에 adapterposition 이용
                }
            }
        });
        photoView = (ImageView) itemView.findViewById(R.id.image_photo);
        nameView = (TextView) itemView.findViewById(R.id.text_name);
        ageView = (TextView) itemView.findViewById(R.id.text_age);

    }

    Person person;

    public void setPerson(Person person) {
        this.person = person;
        photoView.setImageDrawable(person.getPhoto());
        nameView.setText(person.getName());
        ageView.setText("" + person.getAge());
    }
}
