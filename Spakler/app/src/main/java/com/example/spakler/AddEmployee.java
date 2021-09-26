package com.example.spakler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spakler.databinding.ActivityMainBinding;
import com.example.spakler.model.Employee;
import com.example.spakler.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class AddEmployee extends AppCompatActivity {

    public static final String EMPLOYEE_PREFIX = "SPE-00";
    EditText FirstName, LastName, NIC, Address, ContactNumber;
    ImageView GOBack, Profile;

    int ID = 0;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        FirstName = findViewById(R.id.firstName);
        LastName = findViewById(R.id.lastName);
        NIC = findViewById(R.id.nic);
        Address = findViewById(R.id.address);
        ContactNumber = findViewById(R.id.phone_no);
        GOBack = findViewById(R.id.backbtn);
        Profile = findViewById(R.id.profile);

        GOBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(AddEmployee.this, AdminDashboard.class);
                startActivity(go);
            }
        });

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("UserProfile");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ID = (int) snapshot.getChildrenCount();
                System.out.println(ID);
                ID = ID + 1;


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void CreateEmployee(View view) {

        String empFirstName = FirstName.getText().toString();
        String empLastName = LastName.getText().toString();
        String empNIC = NIC.getText().toString();
        String empAddress = Address.getText().toString();
        String empPhoneNumber = ContactNumber.getText().toString();

        if (empFirstName.isEmpty()) {
            FirstName.setError("First name can not be empty.");
        }
        if (empLastName.isEmpty()) {
            LastName.setError("Last name can not be empty.");
        }
        if (empNIC.isEmpty()) {
            NIC.setError("NIC number can not be empty.");
        }
        if (empAddress.isEmpty()) {
            Address.setError("Address can not be empty.");
        }
        if (empPhoneNumber.isEmpty()) {
            ContactNumber.setError("Phone number can not be empty.");
        } else {


            String id = EMPLOYEE_PREFIX + ID;
            Employee employee = new Employee(id, empFirstName, empLastName, empNIC, empAddress, empPhoneNumber);
            reference.child(id).setValue(employee);
            Toast.makeText(AddEmployee.this, "Employee is created successfully.", Toast.LENGTH_SHORT).show();
            Intent refresh = new Intent(getApplicationContext(), AddEmployee.class);
            startActivity(refresh);

        }
    }
}