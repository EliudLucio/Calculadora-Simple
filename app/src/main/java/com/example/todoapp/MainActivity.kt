package com.example.todoapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Forzar modo claro
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContentView(R.layout.activity_main)

        // Configurar Toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Declaramos variables de los objetos
        val etnum1 = findViewById<EditText>(R.id.num1)
        val etnum2 = findViewById<EditText>(R.id.num2)
        val btnCalc = findViewById<android.widget.Button>(R.id.btnCalc)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Cuando se presione el botón "Calcular"
        btnCalc.setOnClickListener{
            val num1 = etnum1.text.toString().toIntOrNull()
            val num2 = etnum2.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                val result = num1 + num2
                tvResult.text = "$result"
            } else {
                Toast.makeText(this, "Valores no validos", Toast.LENGTH_SHORT).show()
            }
        }

        // The Toolbar defined in the layout has the id "my_toolbar".
        setSupportActionBar(findViewById(R.id.toolbar))

    }

    // Inflar el menú en la Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.dropdown_menu -> {
            // Código al darle click
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
            true
        }

        else -> {
            // The user's action isn't recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}