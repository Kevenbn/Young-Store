package com.nascimentokeven.youngstore

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class TelaMostrarProdutos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)

        val produtoTitulo = intent.getStringExtra("TAG_TITULO")
        val produtoPreco = intent.getStringExtra("TAG_PRECO")
        val produtoImagemId = intent.getIntExtra("TAG_IMAGEM", 0)

        val tvTitulo = findViewById<TextView>(R.id.acProdutoTvtitulo)
        val tvPreco = findViewById<TextView>(R.id.acProdutoTvPreco)
        val ivImagem = findViewById<ImageView>(R.id.acProdutoIvimagem)

        tvTitulo.text = produtoTitulo.toString()
        tvPreco.text = produtoPreco.toString()
        ivImagem.setImageResource(produtoImagemId)
    }
}
