package com.justhand.appjam.zaza;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.net.Socket;
import java.net.URISyntaxException;

import io.socket.client.IO;

public class ChatActivity extends AppCompatActivity{
    io.socket.client.Socket mSocket;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        try {
            mSocket = IO.socket("http://zazaappjam.run.goorm.io");
            mSocket.connect();
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }



    }
}
