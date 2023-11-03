package com.example.welcomeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //creating object to access

    lateinit var edtText:EditText
    lateinit var welcomebtn:Button
    lateinit var goodbye:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtText = findViewById(R.id.edtText)
        welcomebtn = findViewById(R.id.welcome)
        goodbye = findViewById(R.id.bay)

        //setting onclick listers to cheack wheater user press the button
        welcomebtn.setOnClickListener(){
            welcome()
        }

        goodbye.setOnClickListener(){
            goodBay()
        }
    }

    fun welcome(){
        Toast.makeText(this,"Welcome ${edtText.text.toString()}",Toast.LENGTH_LONG).show()
    }

    fun goodBay(){
        Toast.makeText(this,"Good Bay ${edtText.text.toString()}",Toast.LENGTH_LONG).show()
    }
}