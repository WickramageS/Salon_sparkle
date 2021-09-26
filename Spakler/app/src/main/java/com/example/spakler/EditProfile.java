package com.example.spakler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spakler.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity {

    TextView USERNAME;
    ImageView Back;
    EditText UserNAme, UserEmail, UserContact, UserPassword;
    String userName, userEmail, userContact, userPassword;
    DatabaseReference reference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Intent getUserName = getIntent();
        userName = getUserName.getStringExtra("userName").toString();
        userEmail = getUserName.getStringExtra("userEmail").toString();
        userContact = getUserName.getStringExtra("userContact").toString();
        userPassword = getUserName.getStringExtra("userPassword").toString();

        Back = findViewById(R.id.backbtn);
        UserNAme = findViewById(R.id.userName1);
        UserEmail = findViewById(R.id.userEmail);
        UserContact = findViewById(R.id.userContact);
        UserPassword = findViewById(R.id.userPassword);

        USERNAME = findViewById(R.id.username);

        USERNAME.setText(userName);
        UserNAme.setText(userName);
        UserEmail.setText(userEmail);
        UserContact.setText(userContact);
        UserPassword.setText(userPassword);


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(getApplicationContext(), DashBoard.class);
                startActivity(goBack);
            }
        });

        reference = FirebaseDatabase.getInstance().getReference("userList");
    }

    public void UpdateProfile(View view) {
//        if (isNameChange() || isPasswordChange() || isEmailChange() || isPhoneChange()) {
//            Toast.makeText(this, "Data is updated successfully.", Toast.LENGTH_SHORT).show();
////            Intent goHome = new Intent(getApplicationContext(), Login.class);
////            startActivity(goHome);
//        } else {
//            Toast.makeText(this, "Data is same. Can not be updated.", Toast.LENGTH_SHORT).show();
//        }

        user = new User();

        user.setUserName(UserNAme.getText().toString());
        user.setUserEmail(UserEmail.getText().toString());
        user.setUserContact(UserContact.getText().toString());
        user.setUserPassword(UserPassword.getText().toString());

        reference.child(user.getUserName()).setValue(user);
        Toast.makeText(this, "Data is updated successfully.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }



    public void DeleteProfile(View view) {
        reference = FirebaseDatabase.getInstance().getReference().child("userList").child(userName);
        reference.removeValue();
        Toast.makeText(this, "User is deleted successfully.", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getApplicationContext(), Login.class));
    }


    private boolean isPhoneChange() {
        if (!UserPassword.equals(UserPassword.getEditableText().toString())) {
            reference.child("userName").child("userContact").setValue(UserEmail.getEditableText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChange() {
        if (!UserPassword.equals(UserPassword.getEditableText().toString())) {
            reference.child("userName").child("userEmail").setValue(UserEmail.getEditableText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean isNameChange() {
        if (!userName.equals(UserNAme.getEditableText().toString())) {
            reference.child("userName").setValue(UserNAme.getEditableText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordChange() {
        if (!UserPassword.equals(UserPassword.getEditableText().toString())) {
            reference.child("userName").child("userPassword").setValue(UserPassword.getEditableText().toString());
            return true;
        } else {
            return false;
        }
    }

}