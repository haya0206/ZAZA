package com.justhand.appjam.zaza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.justhand.appjam.zaza.model.near_user;
import com.justhand.appjam.zaza.model.send_myinfo;

public class MainActivity extends AppCompatActivity {
    Button zanibutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

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
