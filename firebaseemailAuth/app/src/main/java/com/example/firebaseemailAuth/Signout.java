package com.example.firebaseemailAuth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Signout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);

        Button myButton=findViewById(R.id.button3);
        myButton.setOnClickListener(v->{
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signOut();
            Intent myIntent = new Intent(Signout.this, SignupActivity.class);
            Signout.this.startActivity(myIntent);
        });
    }
}