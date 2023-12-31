package com.example.intentsviewmodeltutorial07

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.intentsviewmodeltutorial07.R.id



class MainActivity : AppCompatActivity() {
    var count = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView:TextView = findViewById(R.id.textView)
        val button:Button = findViewById(R.id.button)
        val viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        textView.text = viewModel.count.value.toString()

        button.setOnClickListener(){
            viewModel.increment()
        }

       viewModel.count.observe(this){
           textView.text = it.toString()
       }
       // textView.text = count.toString()

       /* button.setOnClickListener(){
            count ++
            textView.text = count.toString()
        }*/


    }
}