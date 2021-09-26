// Generated by view binder compiler. Do not edit!
package com.example.spakler.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.spakler.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddEmployeeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout LL1;

  @NonNull
  public final EditText address;

  @NonNull
  public final ImageView backbtn;

  @NonNull
  public final TextView create;

  @NonNull
  public final EditText firstName;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final EditText lastName;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final EditText nic;

  @NonNull
  public final EditText phoneNo;

  @NonNull
  public final ImageView profile;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView3;

  private ActivityAddEmployeeBinding(@NonNull ConstraintLayout rootView, @NonNull LinearLayout LL1,
      @NonNull EditText address, @NonNull ImageView backbtn, @NonNull TextView create,
      @NonNull EditText firstName, @NonNull ImageView imageView3, @NonNull EditText lastName,
      @NonNull LinearLayout linearLayout, @NonNull EditText nic, @NonNull EditText phoneNo,
      @NonNull ImageView profile, @NonNull TextView textView, @NonNull TextView textView3) {
    this.rootView = rootView;
    this.LL1 = LL1;
    this.address = address;
    this.backbtn = backbtn;
    this.create = create;
    this.firstName = firstName;
    this.imageView3 = imageView3;
    this.lastName = lastName;
    this.linearLayout = linearLayout;
    this.nic = nic;
    this.phoneNo = phoneNo;
    this.profile = profile;
    this.textView = textView;
    this.textView3 = textView3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddEmployeeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddEmployeeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_employee, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddEmployeeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LL1;
      LinearLayout LL1 = ViewBindings.findChildViewById(rootView, id);
      if (LL1 == null) {
        break missingId;
      }

      id = R.id.address;
      EditText address = ViewBindings.findChildViewById(rootView, id);
      if (address == null) {
        break missingId;
      }

      id = R.id.backbtn;
      ImageView backbtn = ViewBindings.findChildViewById(rootView, id);
      if (backbtn == null) {
        break missingId;
      }

      id = R.id.create;
      TextView create = ViewBindings.findChildViewById(rootView, id);
      if (create == null) {
        break missingId;
      }

      id = R.id.firstName;
      EditText firstName = ViewBindings.findChildViewById(rootView, id);
      if (firstName == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.lastName;
      EditText lastName = ViewBindings.findChildViewById(rootView, id);
      if (lastName == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.nic;
      EditText nic = ViewBindings.findChildViewById(rootView, id);
      if (nic == null) {
        break missingId;
      }

      id = R.id.phone_no;
      EditText phoneNo = ViewBindings.findChildViewById(rootView, id);
      if (phoneNo == null) {
        break missingId;
      }

      id = R.id.profile;
      ImageView profile = ViewBindings.findChildViewById(rootView, id);
      if (profile == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      return new ActivityAddEmployeeBinding((ConstraintLayout) rootView, LL1, address, backbtn,
          create, firstName, imageView3, lastName, linearLayout, nic, phoneNo, profile, textView,
          textView3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}