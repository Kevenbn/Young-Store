package com.nascimentokeven.youngstore

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaSeusdados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_seusdados)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.Barra_teste2)
        bottomNavigationView.selectedItemId = R.id.menu_usuario
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    val i = Intent(applicationContext, TelaProdutos::class.java)
                    val options = ActivityOptions.makeCustomAnimation(
                        this,
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                    ).toBundle()
                    startActivity(i, options)
                    finish()
                    true
                }
                R.id.menu_categorias -> {
                    val i = Intent(applicationContext, TelaCategorias::class.java)
                    val options = ActivityOptions.makeCustomAnimation(
                        this,
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                    ).toBundle()
                    startActivity(i, options)
                    finish()
                    true
                }

                R.id.menu_carrinho -> {
                    val i = Intent(applicationContext, TelaCarrinho::class.java)
                    val options = ActivityOptions.makeCustomAnimation(
                        this,
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                    ).toBundle()
                    startActivity(i, options)
                    finish()
                    true
                }

                R.id.menu_usuario -> {
                    val i = Intent(applicationContext, TelaConta::class.java)
                    val options = ActivityOptions.makeCustomAnimation(
                        this,
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                    ).toBundle()
                    startActivity(i, options)
                    finish()
                    true
                }

                else -> false
            }
        }

    }

}