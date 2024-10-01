package com.example.miprimeraapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ControlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_control)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")

        val accesoCorrecto = Intent(this, Calculadora::class.java)
        val accesoIncorrecto = Intent(this, MainActivity::class.java)

        if(user.equals("alonso") && pass.equals("fdez")){
            accesoCorrecto.putExtra("user", user)
            startActivity(accesoCorrecto)
        }else {
            startActivity(accesoIncorrecto)
        }
        finish()
    }
}