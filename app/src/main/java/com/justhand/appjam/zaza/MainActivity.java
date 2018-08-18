package com.justhand.appjam.zaza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.justhand.appjam.zaza.model.near_user;
import com.justhand.appjam.zaza.model.send_myinfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.socket.client.IO;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    Button zanibutton;
    //io.socket.client.Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        final TextView testtext = findViewById(R.id.testtext);
        ArrayList<user_model> list = (ArrayList<user_model>) intent.getSerializableExtra("Users");

        for(user_model a : list){
            testtext.setText(a.getName());
        }
        Toast.makeText(getApplicationContext(),"fuck",Toast.LENGTH_SHORT);







        zanibutton = findViewById(R.id.zanibutton);
        zanibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
            }
        });






       /* near_user near_user = new near_user();
        send_myinfo send_myinfo = new send_myinfo();
*/
    }



}
