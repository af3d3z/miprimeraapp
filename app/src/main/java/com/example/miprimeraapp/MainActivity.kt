package com.example.miprimeraapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var TAG = ":::vida"
    companion object {
        lateinit var label: EditText
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: Recien creada")

        label = findViewById<EditText>(R.id.username)

        findViewById<Button>(R.id.accessButton).setOnClickListener {
            setContentView(R.layout.bienvenida)
            Log.d(TAG, label.getText().toString())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Acaba de arrancar la app.")
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onResume: La app vuelve a correr.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: La app se ha reiniciado.")
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

}