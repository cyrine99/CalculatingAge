package com.example.calculatingageinminutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Saplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saplash)

        setTitle("احسب عمرك ")

        val but : Button  = findViewById(R.id.button)

        but.setOnClickListener {
             val i =  Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }



    }
}