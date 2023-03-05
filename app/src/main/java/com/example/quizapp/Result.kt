package com.example.quizapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        var img = arrayOf(R.drawable.failed, R.drawable.passed2, R.drawable.okeyokey)

        val name = intent.getStringExtra("userName")
        val correct1 = intent.getStringExtra("correct")
        var image : ImageView = findViewById(R.id.image_result)
        var score : TextView = findViewById(R.id.score)
        var gratitude : TextView = findViewById(R.id.username_result)
        var about : Button = findViewById(R.id.about_developer)

        var correctNumberOfAns = correct1?.toInt()

        if (correctNumberOfAns != null) {
            score.text = "${correctNumberOfAns}/5"

            if(correctNumberOfAns<=4 && correctNumberOfAns>2){
                image.setImageResource(img[2])
                gratitude.text = "Congrats!  ${name} "
            }
            else if(correctNumberOfAns<3) {
                image.setImageResource(img[0])
                gratitude.text = "Not Good!  ${name} "
            }else{
                image.setImageResource(img[1])
                gratitude.text = "Excellent !!   ${name} "
            }
        }
        about.setOnClickListener{
            intent = Intent(this, developer::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed(){
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}