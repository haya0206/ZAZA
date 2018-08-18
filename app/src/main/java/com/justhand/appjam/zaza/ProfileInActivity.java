package com.justhand.appjam.zaza;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;


public class ProfileInActivity extends AppCompatActivity {
    TextView profile_img_add_btn;   //사진추가
    RecyclerView profile_img_list;  //사진 리스트
    EditText name_edit_text,age_edit_text,bio_edit_text;        //이름, 나이, 한줄소개 입력
    RadioGroup toggle, taste_toggle;
    RadioButton my_gender,taste_gender;
    Button finish_btn;

    io.socket.client.Socket mSocket;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_in);

        profile_img_list =  findViewById(R.id.profile_img_list);
        //사진 추가 버튼
        profile_img_add_btn = findViewById(R.id.profile_img_add_btn);
        profile_img_add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //사진 추가


            }
        });
        finish_btn = findViewById(R.id.finish_btn);
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_edit_text = findViewById(R.id.name_edit_text);
                age_edit_text = findViewById(R.id.age_edit_text);
                bio_edit_text = findViewById(R.id.bio_edit_text);
                toggle = findViewById(R.id.toggle);
                my_gender = findViewById(toggle.getCheckedRadioButtonId());
                taste_toggle = findViewById(R.id.taste_toggle);
                taste_gender = findViewById(taste_toggle.getCheckedRadioButtonId());

                SharedPreferences user_profile = getSharedPreferences("user_profile", MODE_PRIVATE);
                SharedPreferences.Editor editor = user_profile.edit();
                editor.putString("name", name_edit_text.getText().toString());
                editor.putString("age", age_edit_text.getText().toString());
                editor.putString("bio", bio_edit_text.getText().toString());
                editor.putString("my_gender", my_gender.getText().toString()); //여자, 남자
                editor.putString("taste_gender", taste_gender.getText().toString()); //여자, 남자
                editor.commit(); //완료한다.

                try {
                    mSocket = IO.socket("http://zazaappjam.run.goorm.io");
                    mSocket.connect();
                } catch(URISyntaxException e) {
                    e.printStackTrace();
                }


                JSONObject user_list = new JSONObject();
                try {
                    user_list.put("id", mSocket.id());
                    user_list.put("name", name_edit_text.getText().toString());
                    user_list.put("age", age_edit_text.getText().toString());
                    user_list.put("bio", bio_edit_text.getText().toString());
                    user_list.put("my_gender", my_gender.getText().toString()); //여자, 남자
                    user_list.put("taste_gender", taste_gender.getText().toString()); //여자, 남자

                } catch(JSONException e) {
                    e.printStackTrace();
                }
                mSocket.emit("list", user_list);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
                finish();
            }
        });









    }
}
