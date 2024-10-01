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

        // recogemos las credenciales provistas por el usuario
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")

        // dejamos preparadas los dos posibles intents que se usen
        val accesoCorrecto = Intent(this, Calculadora::class.java)
        val accesoIncorrecto = Intent(this, MainActivity::class.java)

        /*
            comprobamos que las credenciales son correctas, de serlo lanza la calculadora, de lo
            contrario devuelve al usuario al login
        */
        if(user.equals("alonso") && pass.equals("fdez")){
            accesoCorrecto.putExtra("user", user)
            startActivity(accesoCorrecto)
        }else {
            startActivity(accesoIncorrecto)
        }
        finish()
    }
}