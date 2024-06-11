package com.nascimentokeven.youngstore.ui

data class ProdutosFirebase(
    private val Titulo: String,
    private val Preco: String,
    private val Descricao: String,
    private val Imagem: String)
{
    constructor() : this("","","","")
}
