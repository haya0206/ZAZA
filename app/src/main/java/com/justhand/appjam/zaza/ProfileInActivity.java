package com.justhand.appjam.zaza;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileInActivity extends AppCompatActivity {
    TextView profile_img_add_btn;
    RecyclerView picture_text;
    EditText name_text;

    
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_in);

        //사진 추가 버튼
        profile_img_add_btn = findViewById(R.id.profile_img_add_btn);
        profile_img_add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //사진 추가
            }
        });

        picture_text =  findViewById(R.id.picture_text);
        //name_text = findViewById(R.id.name_text);






    }
}
