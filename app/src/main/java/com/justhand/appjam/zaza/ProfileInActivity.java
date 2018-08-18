package com.justhand.appjam.zaza;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class ProfileInActivity extends AppCompatActivity {
    TextView profile_img_add_btn;   //사진추가
    RecyclerView profile_img_list;  //사진 리스트
    EditText name_edit_text,age_edit_text,bio_edit_text;        //이름, 나이, 한줄소개 입력
    RadioGroup toggle, taste_toggle;
    RadioButton my_gender,taste_gender;
    Button finish_btn;

    List<user_model> userModel;

    io.socket.client.Socket mSocket;
    public String a;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_in);



        try {
            mSocket = IO.socket("http://zazaappjam.run.goorm.io");
            mSocket.connect();
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }

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



                JSONObject user_list = new JSONObject();
                try {
                    user_list.put("id", mSocket.id().toString());
                    user_list.put("name", name_edit_text.getText().toString());
                    user_list.put("age", age_edit_text.getText().toString());
                    user_list.put("bio", bio_edit_text.getText().toString());
                    user_list.put("my_gender", my_gender.getText().toString()); //여자, 남자
                    user_list.put("taste_gender", taste_gender.getText().toString()); //여자, 남자

                } catch(JSONException e) {
                    e.printStackTrace();
                }
                mSocket.emit("list", user_list);

                JSONObject nameonly = new JSONObject();
                try {
                    nameonly.put("name",user_profile.getString("name","honggildong"));

                } catch(JSONException e) {
                    e.printStackTrace();
                }

                mSocket.emit("listSend",nameonly);

                //Emitter.Listener getList =
                mSocket.on("list", new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        try {
                            JSONObject users = (JSONObject) args[0];
                            Iterator<String> temp = users.keys();
                            userModel = new ArrayList<user_model>();
                            while (temp.hasNext()) {
                                String key = temp.next();
                                JSONObject userjson = new JSONObject(users.get(key).toString());
                                Log.e("value check : ",userjson.get("name").toString());
                                String name = userjson.get("name").toString();


                                user_model e = new user_model(
                                        userjson.get("name").toString(),
                                        userjson.get("age").toString(),
                                        userjson.get("bio").toString(),
                                        userjson.get("my_gender").toString(),
                                        userjson.get("taste_gender").toString()
                                );
                                userModel.add(e);
                                userModel.size();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        userModel.size();


                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("Users", (Serializable) userModel);
                        startActivity(intent);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
                        mSocket.close();
                        finish();
                    }
                });

/*
                userModel.size();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Users", (Parcelable) userModel);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
                finish();*/
            }
        });

    }
}
