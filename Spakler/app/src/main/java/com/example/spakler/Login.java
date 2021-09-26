package com.example.spakler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spakler.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {


    DatabaseReference reference;
    TextView EmailLogin, PassLogin;
    Button LoginButton;
    TextView SignUpText;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailLogin = findViewById(R.id.email_login);
        PassLogin = findViewById(R.id.pass_login);

        LoginButton = findViewById(R.id.loginButton);
        SignUpText = findViewById(R.id.signUpText);

        SignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent(getApplicationContext(), Register.class);
                startActivity(reg);
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailLogin = EmailLogin.getText().toString();
                String passLogin = PassLogin.getText().toString();

                if (emailLogin.isEmpty()) {
                    EmailLogin.setError("Email can not be empty.");
                }
                if (passLogin.isEmpty()) {
                    PassLogin.setError("Password can not be empty.");
                } else {


                   reference = FirebaseDatabase.getInstance().getReference("userList");
                   reference.addListenerForSingleValueEvent(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           if(snapshot.hasChild(emailLogin)){

                               final String userPassword = snapshot.child(emailLogin).child("userPassword").getValue(String.class);
                               String userName = snapshot.child(emailLogin).child("userName").getValue(String.class);
                               String userContact = snapshot.child(emailLogin).child("userContact").getValue(String.class);
                               String userEmail = snapshot.child(emailLogin).child("userEmail").getValue(String.class);


                               if(userPassword.equals(passLogin)){
                                   Toast.makeText(Login.this, "Login Successfully.", Toast.LENGTH_SHORT).show();
                                   Intent go = new Intent(getApplicationContext(), DashBoard.class);
                                   go.putExtra("userName", userName);
                                   go.putExtra("userEmail", userEmail);
                                   go.putExtra("userContact", userContact);
                                   go.putExtra("userPassword", userPassword);
                                   startActivity(go);
                               }else {
                                   Toast.makeText(Login.this, "Wrong password or not a valid user. Login Failed.", Toast.LENGTH_SHORT).show();

                               }

                           }else {
                               Toast.makeText(Login.this, "Wrong password or not a valid user. Login Failed.", Toast.LENGTH_LONG).show();

                           }
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                       }
                   });

                }
            }

    });

}
}