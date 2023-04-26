package com.example.roomlab

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewWordActivity : AppCompatActivity() {

    private lateinit var editWordView: EditText
    private lateinit var editCatView: EditText
    private lateinit var editIdioma: EditText
    private lateinit var editOcorrencias: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editWordView = findViewById(R.id.edit_word)
        editCatView = findViewById(R.id.edit_category)
        editIdioma = findViewById(R.id.edit_idioma)
        editOcorrencias = findViewById(R.id.edit_ocorrencias)


        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                val cat = editCatView.text.toString()
                val idioma = editIdioma.text.toString()
                val ocorrencias = editOcorrencias.text.toString()
                replyIntent.putExtra(EXTRA_REPLY_WORD, word)
                replyIntent.putExtra(EXTRA_REPLY_CAT, cat)
                replyIntent.putExtra(EXTRA_REPLY_IDIOMA, idioma)
                replyIntent.putExtra(EXTRA_REPLY_OCORRENCIAS, ocorrencias)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY_WORD = "com.example.android.wordlistsql.REPLY"
        const val EXTRA_REPLY_CAT = ""
        const val EXTRA_REPLY_IDIOMA = ""
        const val EXTRA_REPLY_OCORRENCIAS = ""
    }
}