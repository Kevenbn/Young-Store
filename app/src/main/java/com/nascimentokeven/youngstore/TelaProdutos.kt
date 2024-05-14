package com.nascimentokeven.youngstore

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import com.nascimentokeven.youngstore.R.id.list_view

class TelaProdutos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_account)

        val produtosListView = findViewById<ListView>(list_view)

        val produtos = arrayOf(
            Produto()
        )

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
    }
}