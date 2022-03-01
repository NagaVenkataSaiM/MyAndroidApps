package com.example.stsearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fossVsFossID=HashMap<String, Int>()
        fossVsFossID.put("Java",10)
        fossVsFossID.put("Cpp",57)
        fossVsFossID.put("Python",26)
        fossVsFossID.put("RDBMS",92)

        var languageVsLanguageID = HashMap<String, Int>()
        languageVsLanguageID.put("English",22)
        languageVsLanguageID.put("Hindi",6)
        languageVsLanguageID.put("Gujarati",5)
        languageVsLanguageID.put("Tamil",18)
        languageVsLanguageID.put("Marathi",12)
        languageVsLanguageID.put("Kannada",7)

        var fossVsLanguage = HashMap<String,ArrayList<String>>()
        var availableLanguageForFoss: ArrayList<String>
        availableLanguageForFoss=
            arrayListOf("English","Hindi","Gujarati","Tamil","Marathi","Kannada")
        fossVsLanguage.put("Java",availableLanguageForFoss)
        availableLanguageForFoss=
            arrayListOf("English","Hindi","Gujarati","Tamil","Marathi","Kannada")
        fossVsLanguage.put("Cpp",availableLanguageForFoss)
        availableLanguageForFoss=
            arrayListOf("English","Hindi")
        fossVsLanguage.put("Python",availableLanguageForFoss)
        availableLanguageForFoss=
            arrayListOf("English")
        fossVsLanguage.put("RDBMS",availableLanguageForFoss)
        var fossSpinner= findViewById<Spinner>(R.id.spinner1)
        var languageSpinner= findViewById<Spinner>(R.id.spinner2)
        var fossOptions=fossVsFossID.keys.toList()
        var languageoptions =languageVsLanguageID.keys.toMutableList()
        var selectedFoss="none"
        var selectedLanguage="none"
        var fossAdapter=ArrayAdapter<String>(applicationContext,
            android.R.layout.simple_list_item_activated_1,fossOptions
        )
        fossSpinner.adapter=fossAdapter
        var languageAdapter=ArrayAdapter<String>(applicationContext,
            android.R.layout.simple_list_item_activated_1,languageoptions
        )
        languageSpinner.adapter=languageAdapter
        fossSpinner.onItemSelectedListener=
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                   languageoptions.clear()
                    selectedFoss=fossOptions.get(position)
                    languageoptions.addAll(ArrayList(fossVsLanguage.get(selectedFoss)))
                    languageAdapter.notifyDataSetChanged()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        languageSpinner.onItemSelectedListener=
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedLanguage=languageoptions.get(position)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        var searchButton:Button = findViewById(R.id.button)
        searchButton.setOnClickListener{
            if(selectedFoss=="none"||selectedLanguage=="none")
            {
                Toast.makeText(this,"Please select FOSS and Language",
                Toast.LENGTH_SHORT).show()
            }
            else
            {
                var fossID = fossVsFossID.get(selectedFoss)
                var languageid=languageVsLanguageID.get(selectedLanguage)
                var searchItent=
                    Intent(this, SecondActivity::class.java).apply{
                        putExtra("fossID",""+fossID)
                        putExtra("languageID",""+languageid)
                    }
                startActivity(searchItent)
            }
        }
    }
}