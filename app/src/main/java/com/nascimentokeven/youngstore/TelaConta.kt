package com.nascimentokeven.youngstore

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaConta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_account)

        val btseusdados = findViewById<Button>(R.id.Bt_SeusDados)

        btseusdados.setOnClickListener() {
            val intent = Intent(this, TelaSeusdados::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.Barra_teste2)
        bottomNavigationView.selectedItemId = R.id.menu_usuario
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    val i = Intent(applicationContext, TelaProdutos::class.java)
                    val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                    startActivity(i, options)
                    finish()
                    true}
                R.id.menu_categorias -> {
                    val i = Intent(applicationContext, TelaCategorias::class.java)
                    val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                    startActivity(i, options)
                    finish()
                    true
                }
                R.id.menu_carrinho -> {
                    val i = Intent(applicationContext, TelaCarrinho::class.java)
                    val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                    startActivity(i, options)
                    finish()
                    true
                }
                R.id.menu_usuario -> {
                    true
                }
                else -> false
            }
        }
    }
}