package com.example.stsearch

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class SecondActivity : AppCompatActivity() {
    var finalResultsArrayList=ArrayList<videoItem>()
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var foss =intent.getStringExtra("fossID")
        var language =intent.getStringExtra("languageID")
        var Sop:TextView =findViewById(R.id.textView3)
       Sop.text= "Foss ID : "+foss+"\nLanguage ID : "+language
        var myRecyclerView=findViewById<RecyclerView>(R.id.Rv1)
        myAdapter=MyAdapter(applicationContext,finalResultsArrayList)
        myRecyclerView.layoutManager=LinearLayoutManager(this)
        myRecyclerView.setHasFixedSize(true)
        myRecyclerView.adapter=myAdapter
        val queue=Volley.newRequestQueue(this)
        val url ="https://spoken-tutorial.org/api/get_tutorials/"+foss+"/"+language
        val stringRequest= StringRequest(Request.Method.GET,url,
                Response.Listener<String> { response ->
                    Toast.makeText(applicationContext, "Received server response", Toast.LENGTH_SHORT).show()
                    extractJsonData(response)
                },Response.ErrorListener {
                    Toast.makeText(applicationContext,"Unable to connect to the server",Toast.LENGTH_SHORT).show()
        })
        Toast.makeText(applicationContext,
        "Contacting Server....",Toast.LENGTH_SHORT).show()
        queue.add(stringRequest)
    }
    private fun extractJsonData(jsonResponse: String){
        var videoDataArray= JSONArray(jsonResponse)
        var singleVideoJsonObject: JSONObject
        var singleVideoITEM: videoItem
        var i=0
        var size=videoDataArray.length()
        while(i<size)
        {
            singleVideoJsonObject=videoDataArray.getJSONObject(i)
            singleVideoITEM= videoItem(singleVideoJsonObject.getString("video_id"),
            singleVideoJsonObject.getString("tutorial_name"),
            singleVideoJsonObject.getString("tutorial_level"))
            finalResultsArrayList.add(singleVideoITEM)
            i++
        }
        println("The parsed video items are :")
        finalResultsArrayList.forEach { println(it) }
        myAdapter.notifyDataSetChanged()
    }
}