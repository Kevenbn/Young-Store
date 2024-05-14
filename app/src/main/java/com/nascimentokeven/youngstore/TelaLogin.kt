package com.nascimentokeven.youngstore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class TelaLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        val tvRegister = findViewById<Button>(R.id.Bt_Register)
        val etLogin = findViewById<EditText>(R.id.Et_Login)
        val etPass = findViewById<EditText>(R.id.Et_LPass)

        tvRegister.setOnClickListener() {
            val intent = Intent(this, TelaRegisto::class.java)
            startActivity(intent)
        }
    }
}