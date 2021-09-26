package com.example.spakler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.experimental.UseExperimental;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spakler.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    public static final String USER_PREFIX = "SPU-00";
    Button RegisterButton;
    TextView RegisterText;
    EditText UserName, Email, PhoneNo, Password;
    ProgressDialog progressDialog;
    ProgressBar progressBar;
    int ID = 0;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterButton = findViewById(R.id.registerButton);
        RegisterText = findViewById(R.id.signInText);
        UserName = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        PhoneNo = findViewById(R.id.phone_no);
        Password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar_Reg);
        progressDialog = new ProgressDialog(this);


        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uName = UserName.getText().toString();
                String uEmail = Email.getText().toString();
                String uPhone = PhoneNo.getText().toString();
                String uPass = Password.getText().toString();

                if (uName.isEmpty()) {
                    UserName.setError("User Name can not be empty.");
                }
                if (uEmail.isEmpty()) {
                    UserName.setError("Email can not be empty.");
                }
                if (uPhone.isEmpty()) {
                    UserName.setError("Phone number can not be empty.");
                }
                if (uPass.isEmpty()) {
                    UserName.setError("Password can not be empty.");
                }
                if (!uEmail.matches(emailPattern)) {
                    Email.setError("Email is not a valid email. Please enter valid email.");
                }
                if (!uPass.matches(passwordPattern)) {
                    Password.setError("Password must be include a digit, a lower, an upper, a special and no whitespace allowed.");
                } else {


                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("userList");

                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            ID = (int) snapshot.getChildrenCount();
                            System.out.println(ID);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    ID = ID + 1;

                    String id = USER_PREFIX + ID;
                    User user = new User(id, uName, uEmail, uPhone, uPass);
                    reference.child(uName).setValue(user);
                    Toast.makeText(Register.this, "User is added successfully.", Toast.LENGTH_SHORT).show();

                    Intent reg = new Intent(getApplicationContext(), Login.class);
                    startActivity(reg);
                }

            }
        });


        RegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}