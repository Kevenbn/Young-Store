package com.nascimentokeven.youngstore

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaCarrinho : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        val produtoTitulo = intent.getStringExtra("TAG_TITULO")
        val produtoPreco = intent.getStringExtra("TAG_PRECO")
        val produtoImagemId = intent.getIntExtra("TAG_IMAGEM", 0)

        val tvTitulo = findViewById<TextView>(R.id.Tv_Carrinho_Titulo_produto)
        val tvPreco = findViewById<TextView>(R.id.Tv_Carrinho_Preco_produto)
        val ivImagem = findViewById<ImageView>(R.id.Iv_Carrinho_Produto)

        tvTitulo.text = produtoTitulo.toString()
        tvPreco.text = produtoPreco.toString()
        ivImagem.setImageResource(produtoImagemId)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.Barra_teste2)
        bottomNavigationView.selectedItemId = R.id.menu_carrinho
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