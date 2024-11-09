package com.example.calculadora

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var operand1: Double? = null
    private var pendingOperation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        // Numeric buttons
        val buttonIds = arrayOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9
        )

        for (id in buttonIds) {
            findViewById<Button>(id).setOnClickListener {
                val buttonText = (it as Button).text.toString()
                if (display.text == "0") {
                    display.text = buttonText
                } else {
                    display.append(buttonText)
                }
            }
        }

        // Operation buttons
        findViewById<Button>(R.id.buttonAdd).setOnClickListener { onOperation("+") }
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener { onOperation("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { onOperation("*") }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { onOperation("/") }
        findViewById<Button>(R.id.buttonEquals).setOnClickListener { onOperation("=") }

        // Clear button
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            display.text = ""
            operand1 = null
            pendingOperation = ""
        }
    }

    private fun onOperation(operation: String) {
        val value = display.text.toString().toDoubleOrNull()
        if (value != null) {
            if (operand1 == null) {
                operand1 = value
            } else {
                if (pendingOperation.isNotEmpty()) {
                    operand1 = performOperation(operand1!!, value, pendingOperation)
                }
            }
        }

        pendingOperation = operation
        display.text = if (operation == "=") operand1.toString() else ""
    }

    private fun performOperation(operand1: Double, operand2: Double, operation: String): Double {
        return when (operation) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> if (operand2 != 0.0) operand1 / operand2 else Double.NaN
            else -> operand2
        }
    }
}