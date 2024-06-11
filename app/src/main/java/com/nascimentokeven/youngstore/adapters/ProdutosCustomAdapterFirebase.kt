package com.nascimentokeven.youngstore.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.nascimentokeven.youngstore.R
import com.nascimentokeven.youngstore.TelaCarrinho
import com.nascimentokeven.youngstore.TelaMostrarProdutos
import com.nascimentokeven.youngstore.entities.Produtos

class ProdutosCustomAdapterFirebase {
    private var titulo: String? = null
    private var preco: String? = null
    private var descricao: String? = null
    private var imagem: String? = null

    constructor() {}  // Necessário para o Firebase

    constructor(titulo: String?, preco: String?, descricao: String?, imagem: String?) {
        this.titulo = titulo
        this.preco = preco
        this.descricao = descricao
        this.imagem = imagem
    }

    fun getTitulo(): String? {
        return titulo
    }

    fun setTitulo(titulo: String?) {
        this.titulo = titulo
    }

    fun getPreco(): String? {
        return preco
    }

    fun setPreco(preco: String?) {
        this.preco = preco
    }

    fun getDescricao(): String? {
        return descricao
    }

    fun setDescricao(descricao: String?) {
        this.descricao = descricao
    }
}