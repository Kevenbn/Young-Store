package com.nascimentokeven.youngstore

import android.app.ActivityOptions
import android.content.Intent
import com.nascimentokeven.youngstore.adapters.ProdutosCustomAdapter
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.slideIn
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nascimentokeven.youngstore.adapters.ProdutosCustomCarrinhoAdapter
import com.nascimentokeven.youngstore.entities.Produtos
import android.database.sqlite.SQLiteDatabase;

class TelaProdutos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_produtos)

        //Criação de banco de Dados
        try {
            val baconDados  = openOrCreateDatabase("DB_PRODUTOS", MODE_PRIVATE,null)

            // Criar Tabela
            baconDados.execSQL("CREATE TABLE IF NOT EXISTS produtos(titulo VARCHAR, preco VARCHAR, descricao VARCHAR)")

            baconDados.execSQL("INSERT INTO produtos(nome,preco,descricao) VALUES (teste,teste)")

        }catch (e: Exception){
            e.printStackTrace()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProdutos)

        val arrayTitulosProdutos = resources.getStringArray(R.array.array_produtos_titulos)
        val arrayPrecosProdutos = resources.getStringArray(R.array.array_produtos_precos)
        val arrayDescricaoProdutos = resources.getStringArray(R.array.array_produtos_descricao)

        val produtos = listOf(
            Produtos(arrayTitulosProdutos[0], arrayPrecosProdutos[0], R.drawable.icon_kit_4_camisetas_masculinas_basicas),
            Produtos(arrayTitulosProdutos[1], arrayPrecosProdutos[1], R.drawable.icon_kit_com_10_cuecas_boxer_microfibra),
            Produtos(arrayTitulosProdutos[2], arrayPrecosProdutos[2], R.drawable.icon_camisa_masculina_canelada_gola_alta),
            Produtos(arrayTitulosProdutos[3], arrayPrecosProdutos[3], R.drawable.icon_kit_de_5_camisa_polo_masculina_algodao),
            Produtos(arrayTitulosProdutos[4], arrayPrecosProdutos[4], R.drawable.alemanha),
            Produtos(arrayTitulosProdutos[5], arrayPrecosProdutos[5], R.drawable.argentina),
        )

        val produtosCarrinho = listOf(
            Produtos(arrayTitulosProdutos[0], arrayPrecosProdutos[0],arrayDescricaoProdutos[0], R.drawable.icon_kit_4_camisetas_masculinas_basicas),
            Produtos(arrayTitulosProdutos[1], arrayPrecosProdutos[1], R.drawable.icon_kit_com_10_cuecas_boxer_microfibra),
            Produtos(arrayTitulosProdutos[2], arrayPrecosProdutos[2], R.drawable.icon_camisa_masculina_canelada_gola_alta),
            Produtos(arrayTitulosProdutos[3], arrayPrecosProdutos[3], R.drawable.icon_kit_de_5_camisa_polo_masculina_algodao),
            Produtos(arrayTitulosProdutos[4], arrayPrecosProdutos[4], R.drawable.alemanha),
            Produtos(arrayTitulosProdutos[5], arrayPrecosProdutos[5], R.drawable.argentina),
        )

        val produtosCustomAdapter = ProdutosCustomAdapter(produtos)
        recyclerView.adapter = produtosCustomAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val produtosCustomCarrinhoAdapter = ProdutosCustomCarrinhoAdapter(produtosCarrinho)
        recyclerView.adapter = produtosCustomCarrinhoAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.Barra_teste2)
        bottomNavigationView.selectedItemId = R.id.menu_home
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> true
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
    fun criarBancoDados() {
        try {
            val bancoDados = openOrCreateDatabase("crudapp", MODE_PRIVATE, null)
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS coisa(" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    " , nome VARCHAR)")
            bancoDados.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}