package com.example.miprimeraapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()  {
    private var TAG = ":::vida"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton = findViewById<Button>(R.id.accessButton)
        boton.setOnClickListener{
            Log.d(TAG, "Pressed button")
            val username = findViewById<EditText>(R.id.username).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()
            Log.d(TAG, "Username: " + username)
            Log.d(TAG, "Password: " + password)

            val intent = Intent(this, ControlActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("password", password)
            startActivity(intent)

        }
    }
/*
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Acaba de arrancar la app.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: La app se ha reiniciado.")
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onResume: La app vuelve a correr.")
    }

    override fun onPause(){
        super.onPause()
        setContentView(R.layout.activity_pause)
        Log.d(TAG, "onPause: Pausada.")
    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop: Se ha parado.")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: Se ha destruido la app.")
        super.onDestroy()
    }
*/
}