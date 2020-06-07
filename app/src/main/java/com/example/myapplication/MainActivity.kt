package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.example.myapplication.adapter.BookAdapter
import com.example.myapplication.model.Book

class MainActivity : AppCompatActivity() {

    private var booksListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        booksListView = findViewById(R.id.books_list_view)
        val books = listOf<Book>(
            Book("1", "book 1", "author 1", "description 1"),
            Book("2", "book 2", "author 2", "description 2"),
            Book("3", "book 3", "author 3", "description 3"),
            Book("4", "book 4", "author 4", "description 4"),
            Book("5", "book 5", "author 5", "description 5"),
            Book("6", "book 6", "author 6", "description 6"),
            Book("7", "book 7", "author 7", "description 7")
        )
        val booksAdapter = BookAdapter(this, books)
        booksListView?.adapter = booksAdapter
        booksListView?.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val book = books[position]
                val intent = Intent(this@MainActivity, BookDescriptionActivity::class.java)
                intent.putExtra("bookDescription", book.description)
                this@MainActivity.startActivity(intent)
            }
    }
}
