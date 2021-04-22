package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }


    fun msg(view: View){
        if(name.text.toString().isEmpty()){
            Toast.makeText(this,"Field Empty",Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this,Questions::class.java)
            intent.putExtra(Constants.user,name.text.toString())
            startActivity(intent)
            finish()
        }
    }



}