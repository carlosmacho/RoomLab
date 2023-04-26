package com.example.roomlab

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(@ColumnInfo(name = "word") val word: String,
                @ColumnInfo(name = "category") val category: String = "Categoria",
                @ColumnInfo(name = "idioma") val idioma: String,
                @ColumnInfo(name = "nr_ocorrencias") val nr_ocorrencias: String,
                @PrimaryKey(autoGenerate = true) val id: Long? = null
)