package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myapplication.model.Book


class BookAdapter(
    context: Context,
    private val booksList: List<Book>
) : ArrayAdapter<Book>(
    context, android.R.layout.simple_list_item_1, booksList
) {
    companion object {
        class BookViewHolder(val bookName: TextView)
    }

    override fun getCount(): Int {
        return booksList.size
    }

    override fun getItem(position: Int): Book? {
        return booksList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val book = booksList[position]
        val resultView: View
        val bookViewHolder: BookViewHolder
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            bookViewHolder = BookViewHolder(view.findViewById(android.R.id.text1))
            view.tag = bookViewHolder
            resultView = view
        } else {
            bookViewHolder = convertView.tag as BookViewHolder
            resultView = convertView
        }

        bookViewHolder.bookName.text = book.name
        return resultView
    }
}