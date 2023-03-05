package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        var username : EditText = findViewById(R.id.username)
        val start : Button = findViewById(R.id.startbtn)
        var about : TextView = findViewById(R.id.about_developer)

        start.setOnClickListener{
            if(username.length()==0){
                username.error = "Name is required"
                username.hint="Enter name here"
            }else{

                val Name = username.getText().toString()
                intent = Intent(this , QuizMain::class.java)
                intent.putExtra("userName", Name)
                startActivity(intent)
            }
        }
        about.setOnClickListener{
            intent = Intent(this, developer::class.java)
            startActivity(intent)
        }
    }
}


