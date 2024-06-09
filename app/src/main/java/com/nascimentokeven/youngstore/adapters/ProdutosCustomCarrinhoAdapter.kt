package com.nascimentokeven.youngstore.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nascimentokeven.youngstore.R
import com.nascimentokeven.youngstore.TelaMostrarProdutos
import com.nascimentokeven.youngstore.entities.Produtos

class ProdutosCustomAdapter(private val produtos: List<Produtos>) :
    RecyclerView.Adapter<ProdutosCustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.Tv_Titulo)
        val tvpreco: TextView = view.findViewById(R.id.Tv_Preco)
        val tvimagem: ImageView = view.findViewById(R.id.Iv_Produto)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.custom_recycler_view_produto, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val produto = produtos[position]

        viewHolder.tvTitulo.text = produto.titulo
        viewHolder.tvpreco.text = produto.preco
        viewHolder.tvimagem.setImageResource(produto.imagem)

        viewHolder.itemView.setOnClickListener {
            openSecondActivity(viewHolder.itemView, produto.titulo, produto.preco, produto.imagem)
        }
    }

    override fun getItemCount() = produtos.size

    private fun openSecondActivity(view: View, titulo: String, preco: String, imagem: Int) {
        val intent = Intent(view.context, TelaMostrarProdutos::class.java)
        intent.putExtra("TAG_TITULO", titulo)
        intent.putExtra("TAG_PRECO", preco)
        intent.putExtra("TAG_IMAGEM", imagem)

        view.context.startActivity(intent)
    }
}