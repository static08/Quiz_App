package com.example.quizapp

data class questionsContent (
    val id:Int,
    val question: String,
    val image: Int,
    val oOne : String,
    val oTwo : String,
    val oThree : String,
    val oFour : String,
    val correct: Int
)