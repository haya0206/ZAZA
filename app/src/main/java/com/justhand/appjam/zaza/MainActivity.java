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

      /*  try {
            mSocket = IO.socket("http://zazaappjam.run.goorm.io");
            mSocket.connect();
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }
*/
       // SharedPreferences user_profile = getSharedPreferences("user_profile", MODE_PRIVATE);
  /*      JSONObject ugly = new JSONObject();
        try {
            ugly.put("id",mSocket.id().toString());
            ugly.put("name",user_profile.getString("name","honggildong"));

        } catch(JSONException e) {
            e.printStackTrace();
        }
        mSocket.emit("renewname",ugly);

        JSONObject nameonly = new JSONObject();
        try {
            nameonly.put("name",user_profile.getString("name","honggildong"));

        } catch(JSONException e) {
            e.printStackTrace();
        }

        mSocket.emit("listsend",nameonly);
        */

       /* Emitter.Listener getList = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                try {
                    JSONObject users = (JSONObject) args[0];
                    Iterator<String> temp = users.keys();
                    while (temp.hasNext()) {
                        String key = temp.next();
                        Object value = users.get(key);



                        Toast toast = new Toast(getApplicationContext());
                        toast.makeText(getApplicationContext(), value.toString(), Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        mSocket.on("list", getList);
*/



//        mSocket.close();
        Intent intent = getIntent();
        final TextView testtext = findViewById(R.id.testtext);
        testtext.setText(intent.getExtras().getString("Users"));
        /*List<user_model> userModel = (List<user_model>) intent.getSerializableExtra("Users");
        for(user_model a : userModel){
            final TextView testtext = findViewById(R.id.testtext);
            testtext.setText(testtext.getText().toString() + "\n" +a.getName());
        }*/







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
