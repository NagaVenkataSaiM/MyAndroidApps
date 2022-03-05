package com.example.firebaseemailAuth;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       FirebaseAuth mAuth = FirebaseAuth.getInstance();

        Button myButton=findViewById(R.id.button);
        myButton.setOnClickListener(v -> {
            TextView vi=findViewById(R.id.editTextTextEmailAddress);
            String email=vi.getText().toString().trim();
            vi=findViewById(R.id.editTextPhone);
            String password=vi.getText().toString().trim();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),
                                "Registration successful!",
                                Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(SignupActivity.this, LoginActivity.class);

                        SignupActivity.this.startActivity(myIntent);
                    }
                    else {


                        Toast.makeText(
                                getApplicationContext(),
                                "Registration failed!!"
                                        + " Please try again later",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        });

    }



}