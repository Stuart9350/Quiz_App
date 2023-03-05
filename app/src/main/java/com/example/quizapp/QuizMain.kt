package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast


class QuizMain : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_main)

        supportActionBar?.hide()

        val handler = Handler()
        var index = 0
        var wrong = 0
        var correct = 0

//        var currentProgress = 20
//        var progressBar : ProgressBar = findViewById(R.id.progressbar)


        var rb1 :RadioButton = findViewById(R.id.radioBtn_1)
        var rb2 :RadioButton = findViewById(R.id.radioBtn_2)
        var rb3 :RadioButton = findViewById(R.id.radioBtn_3)
        var rb4 :RadioButton = findViewById(R.id.radioBtn_4)


        var counting : TextView = findViewById(R.id.counter)
        var que : TextView = findViewById(R.id.questionSection)
        val checkSelected : RadioGroup = findViewById(R.id.radioGroup)
        val next : Button = findViewById(R.id.nextBtn)
        var img : ImageView = findViewById(R.id.image)
        var lin : LinearLayout = findViewById(R.id.tochange)
        var pr_img : ImageView = findViewById(R.id.progress_img)

        val fadeIn = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        fadeIn.duration = 800


        var name = intent.getStringExtra("userName")


        var Questions = arrayOf("This is the flag of which country ?",
                                "What is the name of this sport ?",
                                "In which state of India Taj Mahal is located ?",
                                "Name of planet(Biggest planet in our solar system) ?",
                                "What is brand name of given logo ?")

        var options = arrayOf("India", "America", "Afghanistan", "China",
            "Hockey", "Cricket", "Basket ball", "Kabaddi",
            "Gujrat", "Delhi", "Uttar pradesh", "Panjab",
            "Venus", "Jupiter", "Earth","Sun",
            "adidas", "Nike", "Puma", "Bata")

        var progress = arrayOf(R.drawable.progress1_, R.drawable.progress2_, R.drawable.progress3_,  R.drawable.progress4_,  R.drawable.progress5_)

        var image = arrayOf(R.drawable.indianflag, R.drawable.cricket, R.drawable.tajmahal, R.drawable.jupiter, R.drawable.nike_brand)

        var ans = arrayOf("India", "Cricket", "Uttar pradesh", "Jupiter", "Nike")

        next.setOnClickListener{

            val check = checkSelected.checkedRadioButtonId
            if(check == -1){
                Toast.makeText(applicationContext, "Select an Option", Toast.LENGTH_SHORT).show()
            }
            else{

                lin.startAnimation(fadeIn)

                var result = findViewById<RadioButton>(checkSelected.checkedRadioButtonId)
                var ans_text = result.text.toString()
                if(ans_text == ans[index]){
                    correct += 1
                }else{
                    wrong += 1
                }

                index++
                if(index+1 == 5){
                    next.text="SUBMIT"

                }
                if(index<5){
                    counting.text = "Count ${index+1}/5"
                    que.text= "Q. ${index+1}  " + Questions[index]
                    img.setImageResource(image[index])
                    rb1.text = options[index*4]
                    rb2.text = options[index*4+1]
                    rb3.text = options[index*4+2]
                    rb4.text = options[index*4+3]

                    pr_img.setImageResource(progress[index])

//                    currentProgress += 20
//                    progressBar.setProgress(currentProgress)
//                    progressBar.setMax(100)
                }
                else{
                    var result_total = correct.toString()
                    intent = Intent(this, Result::class.java)
                    intent.putExtra("correct",result_total)
                    intent.putExtra("userName", name)
                    startActivity(intent)
                }
            }
            checkSelected.clearCheck()
        }
    }
    override fun onBackPressed(){
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}


