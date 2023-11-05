package com.example.tutorial08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn01:Button = findViewById(R.id.button)
        val btn02:Button = findViewById(R.id.button2)

        btn01.setOnClickListener(){

        }

        btn02.setOnClickListener(){

        }
    }

    //creating functions

    private fun loadHome(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer , homeFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer , homeFragment).commit()
        }


    }

    private fun loadSettings(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer , settingsFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer , settingsFragment).commit()
        }


    }
}