package com.example.spakler;

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

import com.example.spakler.adapter_class.AllEmployeesListAdapter;
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

public class BeauticianAdapter extends FirebaseRecyclerAdapter<Employee, BeauticianAdapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BeauticianAdapter(@NonNull FirebaseRecyclerOptions<Employee> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BeauticianAdapter.myviewholder holder, @SuppressLint("RecyclerView") int position, @NonNull Employee model) {
        holder.empFirstNAme.setText(model.getFirstName());
        holder.empLastNAme.setText(model.getLastName());

    }

    @NonNull
    @Override
    public BeauticianAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowstylists, parent, false);
        return new BeauticianAdapter.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView  empFirstNAme, empLastNAme;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            empFirstNAme = (TextView) itemView.findViewById(R.id.t1);
            empLastNAme = (TextView) itemView.findViewById(R.id.t2);

        }
    }

}