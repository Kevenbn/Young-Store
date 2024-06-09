package com.nascimentokeven.youngstore

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaCategorias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.Barra_teste2)
        bottomNavigationView.selectedItemId = R.id.menu_categorias
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    val i = Intent(applicationContext, TelaProdutos::class.java)
                    val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                    startActivity(i, options)
                    finish()
                    true}
                R.id.menu_categorias -> {
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
                    val i = Intent(applicationContext, TelaConta::class.java)
                    val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                    startActivity(i, options)
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}