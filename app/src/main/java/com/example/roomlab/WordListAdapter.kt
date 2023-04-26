package com.example.roomlab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class WordListAdapter : ListAdapter<Word, WordListAdapter.WordViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word, current.category, current.idioma, current.nr_ocorrencias)
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)
        private val catItemView: TextView = itemView.findViewById(R.id.textView2)
        private val idiomaItemView: TextView = itemView.findViewById(R.id.textView3)
        private val ocorrenciasItemView: TextView = itemView.findViewById(R.id.textView4)

        fun bind(text: String?, category: String, idioma: String, ocorrencias: String) {
            //wordItemView.text = text.plus("-".plus(category))
            wordItemView.text = text
            catItemView.text = category
            idiomaItemView.text = idioma
            ocorrenciasItemView.text = ocorrencias
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Word>() {
            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem.word == newItem.word
            }
        }
    }
}