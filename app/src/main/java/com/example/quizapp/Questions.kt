package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class Questions() : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPos:Int=1
    private var mQuesList: ArrayList<questionsContent>?=null
    private var mSelectedOptPos : Int = 0
    private var mUser: String? = null
    private var score: Int=0
    constructor(parcel: Parcel) : this() {
        mCurrentPos = parcel.readInt()
        mSelectedOptPos = parcel.readInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUser= intent.getStringExtra(Constants.user)

        mQuesList= Constants.getQuestions()
       /* Log.i("Question Size","${mQuesList.size}")*/

        setQues()

        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        op4.setOnClickListener(this)
        submit.setOnClickListener(this)
    }

    private  fun setQues(){
        
        val question = mQuesList!![mCurrentPos-1]

        defaultOptView()

        if(mCurrentPos == mQuesList!!.size){
            submit.text ="Finish"
        }else{
            submit.text = "Submit"
        }
        progBar.progress= mCurrentPos
        tvProg.text = "$mCurrentPos"+"/"+ progBar.max

        q.text=question!!.question
        img.setImageResource(question.image)
        op1.text=question!!.oOne
        op2.text=question!!.oTwo
        op3.text=question!!.oThree
        op4.text=question!!.oFour
    }

    private fun defaultOptView(){
        val option = ArrayList<TextView>()

        option.add(0,op1)
        option.add(1,op2)
        option.add(2,op3)
        option.add(3,op4)

        for(option in option){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                    this,
                    R.drawable.my
            )
        }
    }

   override fun onClick(v:View?){
        when(v?.id){
            R.id.op1 ->{
                selectedOptView(op1,1)
            }
            R.id.op2 ->{
                selectedOptView(op2,2)
            }
            R.id.op3 ->{
                selectedOptView(op3,3)
            }
            R.id.op4 ->{
                selectedOptView(op4,4)
            }

            R.id.submit ->{
                if(mSelectedOptPos ==0){
                    mCurrentPos++

                    when{
                        mCurrentPos <= mQuesList!!.size ->{
                            setQues()
                        }else ->{
                            submit.setOnClickListener{
                                val intent = Intent(this, Result::class.java)
                                intent.putExtra(Constants.user, mUser)
                                intent.putExtra(Constants.cAns,mQuesList!!.size-score)
                                intent.putExtra(Constants.tQuestions, mQuesList!!.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                }else {
                    val questions = mQuesList?.get(mCurrentPos-1)
                    if(questions!!.correct != mSelectedOptPos){
                        ansView(mSelectedOptPos,R.drawable.wrong_opt_border)
                        score+=1
                    }
                    ansView(questions.correct,R.drawable.correct_opt_border)

                    if(mCurrentPos == mQuesList!!.size){
                        submit.text ="FINISH"
                    }else{
                        submit.text ="Next"
                    }
                    mSelectedOptPos=0
                }
            }

        }
   }

    private fun  ansView(answer:Int , drawableView:Int ){
        when(answer){
            1->{
                op1.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }

            2->{
                op2.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }

            3->{
                op3.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }

            4->{
                op4.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }
        }
    }
    private fun selectedOptView(tv: TextView, selectedOptNo: Int){
        defaultOptView()
        mSelectedOptPos = selectedOptNo

        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
                this,
                R.drawable.selected_border
        )
    }
}

