package com.example.sellerapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    private Button loginSellerBtn;
    private EditText emailInput, passwordInput;
    private ProgressDialog loadingBar;
    private TextView UserRegisterLink;
    private FirebaseAuth mAuth;
    boolean isEmailValid, isPasswordValid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        UserRegisterLink = (TextView)findViewById(R.id.register_link);
        loginSellerBtn = (Button)findViewById(R.id.seller_login_btn);
        emailInput = findViewById(R.id.seller_login_email);
        passwordInput = findViewById(R.id.seller_login_password);
        loadingBar = new ProgressDialog(this);

        loginSellerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetValidation();
            }
        });

        UserRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }


        });

    }

    public void SetValidation() {
        // Check for a valid email address.
        if (emailInput.getText().toString().isEmpty()) {
            emailInput.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput.getText().toString()).matches()) {
            emailInput.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }

        // Check for a valid password.
        if (passwordInput.getText().toString().isEmpty()) {
            passwordInput.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (passwordInput.getText().length() < 6) {
            passwordInput.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
        }

        if (isEmailValid && isPasswordValid) {
            loginSeller();

        }

    }

    private void loginSeller() {

        final String email = emailInput.getText().toString();
        final String password = passwordInput.getText().toString();

        if(!email.equals("") && (!password.equals(""))){
            loadingBar.setTitle(("Login Seller Account"));
            loadingBar.setMessage("Please wait while we check your Credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                loadingBar.dismiss();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(), "Logged In Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            else {
                                Toast.makeText(LoginActivity.this, "Access Denied, Wrong Credentials", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                            }
                        }
                    });




        }else {
            Toast.makeText(LoginActivity.this, "Please Complete The Login Form", Toast.LENGTH_SHORT).show();
        }

    }
}