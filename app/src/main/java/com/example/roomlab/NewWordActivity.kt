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

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editWordView = findViewById(R.id.edit_word)
        editCatView = findViewById(R.id.edit_category)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                val cat = editCatView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY_WORD, word)
                replyIntent.putExtra(EXTRA_REPLY_CAT, cat)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY_WORD = "com.example.android.wordlistsql.REPLY"
        const val EXTRA_REPLY_CAT = ""
    }
}