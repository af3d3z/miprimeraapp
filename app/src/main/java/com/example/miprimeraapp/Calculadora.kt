package com.example.miprimeraapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculadora : AppCompatActivity() {
    companion object {
        private var n1: Float = 0f
        private var n2: Float = 0f
        private var resultado: Float = 0f
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = intent.getStringExtra("user")
        val welcome = findViewById<TextView>(R.id.welcomeText)
        welcome.text = welcome.text.toString() + " " + username;

        suma()
        resta()
        multiplicar()
        dividir()
    }

    private fun cargarNumeros() {
        n1 = findViewById<EditText>(R.id.number1).text.toString().toFloatOrNull()?:0f
        n2 = findViewById<EditText>(R.id.number2).text.toString().toFloatOrNull()?:0f
    }

    fun suma(){
        findViewById<Button>(R.id.suma).setOnClickListener{
            cargarNumeros()
            resultado = n1 + n2
            findViewById<TextView>(R.id.resultado).text = resultado.toString()
            Log.d(":::calc","n1: " + n1 + " n2: " + n2 + " resultado: " + resultado)
        }
    }

    fun resta(){
        findViewById<Button>(R.id.resta).setOnClickListener{
            cargarNumeros()
            resultado = n1 - n2
            findViewById<TextView>(R.id.resultado).text = resultado.toString()
            Log.d(":::calc","n1: " + n1 + " n2: " + n2 + " resultado: " + resultado)
        }
    }

    fun multiplicar(){
        findViewById<Button>(R.id.multiplicar).setOnClickListener{
            cargarNumeros()
            resultado = n1 * n2
            findViewById<TextView>(R.id.resultado).text = resultado.toString()
            Log.d(":::calc","n1: " + n1 + " n2: " + n2 + " resultado: " + resultado)
        }
    }

    fun dividir(){
        findViewById<Button>(R.id.dividir).setOnClickListener{
            cargarNumeros()
            if (n2 == 0f){
                var toast = Toast.makeText(this, "No se puede dividir por cero!!", Toast.LENGTH_SHORT)
                toast.show()
            }else{
                resultado = n1 / n2
            }
            findViewById<TextView>(R.id.resultado).text = resultado.toString()
            Log.d(":::calc","n1: " + n1 + " n2: " + n2 + " resultado: " + resultado)
        }
    }
}