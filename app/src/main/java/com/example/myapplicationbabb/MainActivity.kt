package com.example.myapplicationbabb
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnLeft.setOnClickListener{
checkAnswer(true)
        assignNumbersToButtons()
    }
    btnRight.setOnClickListener {
checkAnswer(false)

        assignNumbersToButtons()
    }
}
    fun checkAnswer(isLeftButtonSelected:Boolean){
        val leftNum=btnLeft.text.toString().toInt()
        val rightNum=btnRight.text.toString().toInt()
        val isAnswerCorrect =if (isLeftButtonSelected)
            leftNum>rightNum
        else
            rightNum>leftNum
        if(isAnswerCorrect) {
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        } else{
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
        }

    }
        fun assignNumbersToButtons() {
            val r = Random()
            val leftNum = r.nextInt(10)
            var rightNum = leftNum
            while (rightNum == leftNum) {
                rightNum = r.nextInt(10)

            }
            btnLeft.text = leftNum.toString()
            btnRight.text = rightNum.toString()


        }
    }


