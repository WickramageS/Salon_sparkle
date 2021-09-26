package com.example.spakler.adapter_class;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spakler.R;
import com.example.spakler.model.Employee;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class AllEmployeesListAdapter extends FirebaseRecyclerAdapter<Employee, AllEmployeesListAdapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AllEmployeesListAdapter(@NonNull FirebaseRecyclerOptions<Employee> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AllEmployeesListAdapter.myviewholder holder, @SuppressLint("RecyclerView") int position, @NonNull Employee model) {
        holder.empID.setText(model.getEmpID());
        holder.empFirstNAme.setText(model.getFirstName());
        holder.empLastName.setText(model.getLastName());
        holder.Nic.setText(model.getNIC());
        holder.Contact.setText(model.getPhoneNo());
        holder.Address.setText(model.getAddress());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.empID.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(true, 1100)
                        .create();

                View myview = dialogPlus.getHolderView();
                final EditText firstName = myview.findViewById(R.id.uname);
                final EditText lastName = myview.findViewById(R.id.vc1);
                final EditText nic = myview.findViewById(R.id.vc2);
                final EditText address = myview.findViewById(R.id.vc3);
                final EditText pNo = myview.findViewById(R.id.vc4);
                Button submit = myview.findViewById(R.id.usubmit);

                firstName.setText(model.getFirstName());
                lastName.setText(model.getLastName());
                nic.setText(model.getNIC());
                address.setText(model.getAddress());
                pNo.setText(model.getPhoneNo());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("firstName", firstName.getText().toString());
                        map.put("lastName", lastName.getText().toString());
                        map.put("nic", nic.getText().toString());
                        map.put("address", address.getText().toString());
                        map.put("phoneNo", pNo.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("UserProfile")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                        Toast.makeText(myview.getContext(), "Update Successfully.", Toast.LENGTH_SHORT).show();

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });


            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.empID.getContext());
                builder.setTitle("Delete Employee");
                builder.setMessage("Do you want to delete this employee permanently?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("UserProfile")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });


    }

    @NonNull
    @Override
    public AllEmployeesListAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView edit, delete;
        TextView empID, empFirstNAme, empLastName, Nic, Contact, Address;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            empID = (TextView) itemView.findViewById(R.id.t1);
            empFirstNAme = (TextView) itemView.findViewById(R.id.t2);
            empLastName = (TextView) itemView.findViewById(R.id.t3);
            Nic = (TextView) itemView.findViewById(R.id.t4);
            Contact = (TextView) itemView.findViewById(R.id.t5);
            Address = (TextView) itemView.findViewById(R.id.t6);

            edit = (TextView) itemView.findViewById(R.id.editicon);
            delete = (TextView) itemView.findViewById(R.id.deleteicon);
        }
    }

}