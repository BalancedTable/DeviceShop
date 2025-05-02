package com.example.yeepee

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val itemList: RecyclerView = findViewById(R.id.itemList)
        val items = arrayListOf<Item>()

        items.add(Item(1,"motherboard","Материнська плата","Lorem ipsum dolor sit amet, ","consectetur adipiscing elit, ", 1500))
        items.add(Item(2,"graphiccard","Відеокарта","Lorem ipsum dolor sit amet, ","consectetur adipiscing elit, ", 1000))
        items.add(Item(3,"processor","Процесор","Lorem ipsum dolor sit amet, ","consectetur adipiscing elit, ", 1250))
        items.add(Item(4,"ram","ОЗУ","Lorem ipsum dolor sit amet, ","consectetur adipiscing elit, ", 600))
        items.add(Item(5,"ssd","Жорсткий диск","Lorem ipsum dolor sit amet, ","consectetur adipiscing elit, ", 150))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = ItemAdapter(items,this)
    }
}