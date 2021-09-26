package com.example.spakler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.spakler.adapter_class.AllEmployeesListAdapter;
import com.example.spakler.model.Employee;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class AllEmployeesList extends AppCompatActivity {

    RecyclerView recyclerView;
    AllEmployeesListAdapter allEmployeesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_employees_list);


        recyclerView = (RecyclerView) findViewById(R.id.recview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Employee> options =
                new FirebaseRecyclerOptions.Builder<Employee>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("UserProfile"), Employee.class)
                        .build();

        allEmployeesList = new AllEmployeesListAdapter(options);
        recyclerView.setAdapter(allEmployeesList);

    }

    @Override
    protected void onStart() {
        super.onStart();
        allEmployeesList.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        allEmployeesList.stopListening();
    }
}