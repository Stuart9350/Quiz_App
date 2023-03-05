package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Override as Override1

class developer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)

    }
    override fun onBackPressed(){
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}