package com.example.spakler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class DashBoard extends AppCompatActivity {

    ImageView Profile;
    RelativeLayout RL1, RL3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Intent getUserName = getIntent();
        String userName = getUserName.getStringExtra("userName").toString();
        String userEmail = getUserName.getStringExtra("userEmail").toString();
        String userContact = getUserName.getStringExtra("userContact").toString();
        String userPassword = getUserName.getStringExtra("userPassword").toString();

        Profile = findViewById(R.id.profile);
        RL1 = findViewById(R.id.rl1);
        RL3 = findViewById(R.id.rl3);

        RL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent go = new Intent(getApplicationContext(), BeauticianList.class);
                startActivity(go);
            }
        });

        RL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent go = new Intent(getApplicationContext(), ServicesCustomer.class);
                startActivity(go);
            }
        });

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(getApplicationContext(), EditProfile.class);
                profile.putExtra("userName",userName);
                profile.putExtra("userEmail",userEmail);
                profile.putExtra("userContact",userContact);
                profile.putExtra("userPassword",userPassword);
                startActivity(profile);
            }
        });

    }
}