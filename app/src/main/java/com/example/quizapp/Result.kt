package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.user)
        username.text = userName

        val c = intent.getIntExtra(Constants.cAns,0)
        val t = intent.getIntExtra(Constants.tQuestions,0)

        tv_score.text= "You scored $c out of $t"

        exit.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}