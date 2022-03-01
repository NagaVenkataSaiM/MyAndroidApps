package com.example.registrationform

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
         var obtainedName=" "
        var obtainedid=" "
        var obtainedbranch=" "
        obtainedName= intent.getStringExtra("Refername").toString()
        obtainedid = intent.getStringExtra("Referid").toString()
        obtainedbranch = intent.getStringExtra("Referbranch").toString()
        var wv:TextView =findViewById(R.id.textView7)
        wv.text="Welcome "+obtainedName+"\nID: "+obtainedid+"\nBRANCH:"+obtainedbranch
    }
}