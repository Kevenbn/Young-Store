package com.nascimentokeven.youngstore.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nascimentokeven.youngstore.R
import com.nascimentokeven.youngstore.TelaCarrinho
import com.nascimentokeven.youngstore.TelaMostrarProdutos
import com.nascimentokeven.youngstore.entities.Produtos

class ProdutosCustomCarrinhoAdapter(private val produtos: List<ProdutosDetalhes>) :
    RecyclerView.Adapter<ProdutosCustomCarrinhoAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.Tv_Carrinho_Titulo_produto)
        val tvpreco: TextView = view.findViewById(R.id.Tv_Carrinho_Preco_produto)
        val tvimagem: ImageView = view.findViewById(R.id.Iv_Carrinho_Produto)
        val btcarrinho: ImageButton = view.findViewById(R.id.Ib_Carrinho_Produto)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.custom_recycler_view_produto_carrinho, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val produto = produtos[position]

        viewHolder.tvTitulo.text = produto.Titulo
        viewHolder.tvpreco.text = produto.Preco
        viewHolder.tvimagem.setImageResource(produto.Imagem)
        viewHolder.btcarrinho.findViewById<ImageButton>(R.id.Ib_Carrinho_Produto)

        viewHolder.btcarrinho.setOnClickListener {
            openCarrinhoActivity(viewHolder.itemView, produto.Titulo, produto.Preco, produto.Descricao, produto.Imagem)
        }
    }

    override fun getItemCount() = produtos.size
    private fun openCarrinhoActivity(view: View, Titulo: String, Preco: String, Descricao: String, Imagem: Int) {
        val intent = Intent(view.context, TelaCarrinho::class.java)
        intent.putExtra("TAG_TITULO", Titulo)
        intent.putExtra("TAG_PRECO", Preco)
        intent.putExtra("TAG_DESCRICAO",Descricao)
        intent.putExtra("TAG_IMAGEM", Imagem)

        view.context.startActivity(intent)
    }
}