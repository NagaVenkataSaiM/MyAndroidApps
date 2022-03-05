package com.example.firebaseemailAuth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button myButton=findViewById(R.id.button2);
        myButton.setOnClickListener(v->{
            FirebaseAuth mAuth=FirebaseAuth.getInstance();
            TextView vi=findViewById(R.id.editTextTextEmailAddress2);
            String email=vi.getText().toString().trim();
            vi=findViewById(R.id.editTextPhone2);
            String password=vi.toString().trim();
            mAuth.signInWithEmailAndPassword(email,password);
            Intent myIntent = new Intent(LoginActivity.this, Signout.class);
            LoginActivity.this.startActivity(myIntent);
        });
    }

}