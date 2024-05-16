package com.example.lab5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.task2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val var1: EditText = findViewById(R.id.var1)
//        val var2: EditText = findViewById(R.id.var2)
//        val operand: TextView = findViewById(R.id.operand)
//        val equal: TextView = findViewById(R.id.equal)
//        val result: TextView = findViewById(R.id.result)
//        var1.addTextChangedListener {
//            equal.visibility = View.INVISIBLE
//            operand.text = ""
//            result.text = ""
//        }
//        var2.addTextChangedListener {
//            equal.visibility = View.INVISIBLE
//            operand.text = ""
//            result.text = ""
//        }
    }

    fun onClickCopy(view: View?) {
        val user_input: EditText = findViewById(R.id.user_input)
        val text: String = user_input.text.toString()
        val textView: TextView = findViewById(R.id.textView)
        textView.text = text
    }

    fun onClickClose(view: View?) {
        finish()
    }

    fun onClickAllow(view: View?) {
        val btn_show : Button = findViewById(R.id.btn_show)
        if (btn_show.visibility != View.VISIBLE) {
            btn_show.visibility = View.VISIBLE
        }
        else {
            btn_show.visibility = View.INVISIBLE
        }
    }

    fun onClickShow(view: View?) {
        val btn_close: Button = findViewById(R.id.btn_close)
        if (btn_close.visibility != View.VISIBLE) {
            btn_close.visibility = View.VISIBLE
        }
        else {
            btn_close.visibility = View.INVISIBLE
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClickOperand(view: View?) {
        val var1: EditText = findViewById(R.id.var1)
        val var2: EditText = findViewById(R.id.var2)
        val var1Num = var1.text.toString().toDouble()
        val var2Num = var2.text.toString().toDouble()
        val operand: TextView = findViewById(R.id.operand)
        val equal: TextView = findViewById(R.id.equal)
        val result: TextView = findViewById(R.id.result)
        when(view?.id) {
            R.id.btn_plus -> result.text = (var1Num + var2Num).toString()
            R.id.btn_minus -> result.text = (var1Num - var2Num).toString()
            R.id.btn_mult -> result.text = (var1Num * var2Num).toString()
            R.id.btn_div -> result.text = (var1Num / var2Num).toString()
        }
        equal.visibility = View.VISIBLE
        operand.text = (view as Button).text
    }
}
