package com.example.firebaseemailAuth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton=findViewById(R.id.signup_button);
        myButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, SignupActivity.class);

           MainActivity.this.startActivity(myIntent);


        });
    }
}