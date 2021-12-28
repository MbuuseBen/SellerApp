package com.example.sellerapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Button registerBtn;
    private TextView sellerloginBegin;
    private EditText nameInput,phoneInput,emailInput,passwordInput,addressInput;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sellerloginBegin = findViewById(R.id.seller_already_have_account_btn);

        registerBtn = (Button)findViewById(R.id.seller_register_btn);

        nameInput= findViewById(R.id.seller_name);
        phoneInput = findViewById(R.id.seller_phone);
        emailInput = findViewById(R.id.seller_email);
        passwordInput = findViewById(R.id.seller_password);
        addressInput = findViewById(R.id.seller_address);
        loadingBar = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();



        sellerloginBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }


        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerSeller();
            }
        });
    }

    private void registerSeller() {

        String name = nameInput.getText().toString();
        String phone = phoneInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String address = addressInput.getText().toString();

        if(!name.equals("") && (!phone.equals("")) && (!email.equals("")) && (!password.equals("")) && (!address.equals("")) ){

            loadingBar.setTitle(("Creating Seller Account"));
            loadingBar.setMessage("Please wait while we check your Credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                                String uid = mAuth.getCurrentUser().getUid();

                                HashMap<String, Object> sellerMap = new HashMap<>();
                                sellerMap.put("sid",uid);
                                sellerMap.put("Phone",phone);
                                sellerMap.put("email",email);
                                sellerMap.put("address",address);
                                sellerMap.put("name",name);


                                rootRef.child("Sellers").child(uid).updateChildren(sellerMap)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull  Task<Void> task) {
                                                loadingBar.dismiss();
                                                Toast.makeText(RegisterActivity.this, "You are Registered Successfully , Please Login",Toast.LENGTH_SHORT).show();

                                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                                                startActivity(intent);

                                            }
                                        });

                            }
                        }
                    });


        }else {
            Toast.makeText(RegisterActivity.this, "Please Complete Registration",Toast.LENGTH_SHORT).show();
        }
    }
}