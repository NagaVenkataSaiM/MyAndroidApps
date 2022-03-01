package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       var name: String ="Empty"
        var id: String ="Empty"
        var branch: String ="Empty"
        var gender: String ="Empty"
        var year:String ="Empty"
        var button: Button = findViewById(R.id.button1)
        var aBox: EditText = findViewById(R.id.aBox1)
        var a1Box: EditText = findViewById(R.id.aBox2)
        var deplist = arrayListOf("CSE","ECE","EEE","ME","BT","others")
        var dptspinner:Spinner =findViewById(R.id.dptspinner)
        dptspinner.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                deplist
        )
        dptspinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        branch = deplist[position]
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

        //var a2Box: EditText = findViewById(R.id.aBox3)
        var a4Box: EditText = findViewById(R.id.aBox4)
       var a3Box: RadioGroup = findViewById(R.id.R1)
        name=aBox.text.toString()
        button.setOnClickListener{
            name=aBox.text.toString()
            id=a1Box.text.toString()
            var gen= a3Box.checkedRadioButtonId
            year=a4Box.text.toString()
            val sg:RadioButton = findViewById(gen)
            gender=sg.text.toString()
            Toast.makeText(applicationContext,"Thank you!", Toast.LENGTH_SHORT).show()
            var intent= Intent(this, SecondActivity::class.java).apply {
                putExtra("Refername",name)
                putExtra("Referid",id)
                putExtra("Referbranch",branch)
            }
          startActivity(intent)
        }
    }
}