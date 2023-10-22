package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {


    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button

    private lateinit var btn_divide: Button
    private lateinit var btn_multiply: Button
    private lateinit var btn_plus: Button
    private lateinit var btn_sub: Button
    private lateinit var btn_equal: Button

    private lateinit var btn_ce: Button
    private lateinit var btn_bs: Button
    private lateinit var btn_c: Button

    private lateinit var expression: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0 = findViewById(R.id.btn_0)
        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)
        btn3 = findViewById(R.id.btn_3)
        btn4 = findViewById(R.id.btn_4)
        btn5 = findViewById(R.id.btn_5)
        btn6 = findViewById(R.id.btn_6)
        btn7 = findViewById(R.id.btn_7)
        btn8 = findViewById(R.id.btn_8)
        btn9 = findViewById(R.id.btn_9)

        btn_divide = findViewById(R.id.btn_divide)
        btn_multiply = findViewById(R.id.btn_multiply)
        btn_plus = findViewById(R.id.btn_plus)
        btn_sub = findViewById(R.id.btn_sub)
        btn_equal = findViewById(R.id.btn_equal)

        btn_ce = findViewById(R.id.btn_ce)
        btn_bs = findViewById(R.id.btn_bs)
        btn_c = findViewById(R.id.btn_c)
        var str = ""
        btn_c.setOnClickListener {
            if (expression.text.toString().isNotEmpty()) {
                val lastIndex = expression.text.toString().lastIndex
                if (!expression.text.toString()[lastIndex].isDigit()){
                    str = expression.text.toString().substring(0, lastIndex)
                    expressionText(str)
                }

            }
        }
        btn_bs.setOnClickListener {
            if (expression.text.toString().isNotEmpty()) {
                val lastIndex = expression.text.toString().lastIndex
                if (expression.text.toString()[lastIndex].isDigit()){
                    str = expression.text.toString().substring(0, lastIndex)
                    expressionText(str)
                }

            }
        }
        btn_ce.setOnClickListener {
            expressionText("0")
        }
        btn_divide.setOnClickListener {
            this.onClick(it)
        }
        btn_multiply.setOnClickListener {
            var str = expression.text.toString()
            str += "*"
            expressionText(str)
        }

        btn_plus.setOnClickListener {
            onClick(it)
        }

        btn_sub.setOnClickListener {
            onClick(it)
        }

        btn_equal.setOnClickListener {
            val txt= expression.text.toString()
            try{
                val res= ExpressionBuilder(txt).build().evaluate()
                expressionText(""+res.toInt())
            }catch (ex:ArithmeticException){
                Log.e("evaluaate error",ex.toString())

            }
        }
        btn0.setOnClickListener {
            onClick(it)
        }

        btn1.setOnClickListener {
            onClick(it)
        }

        btn2.setOnClickListener {
            onClick(it)
        }

        btn3.setOnClickListener {
            onClick(it)
        }

        btn4.setOnClickListener {
            onClick(it)
        }

        btn5.setOnClickListener {
            onClick(it)
        }

        btn6.setOnClickListener {
            onClick(it)
        }

        btn7.setOnClickListener {
            onClick(it)
        }

        btn8.setOnClickListener {
            onClick(it)
        }

        btn9.setOnClickListener {
            onClick(it)
        }
        expression = findViewById(R.id.solution_tv)
    }

    fun onClick(v: View) {
        var str = expression.text.toString()
        val txt=(v as Button).text.toString()
        if(str[0].equals('0') && str.length==1 && txt[0].isDigit()) str= str.substring(1)
        str += (v as Button).text.toString()
        expressionText(str)
    }


    private fun expressionText(str: String) {
        expression.text = str;
    }



}