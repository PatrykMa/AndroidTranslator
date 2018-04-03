package com.example.patryk.tlumacz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.net.URL
import java.util.concurrent.Executors

class learnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)


        val button: Button = findViewById<Button>(R.id.LAButton) as Button

        button.setOnClickListener{

            //Toast.makeText(this, "kliknieto", Toast.LENGTH_SHORT).show()
           // var db =DataBase(this)
           // var kat = Category()
            //kat.Kategoria="pierwsza"
            //db.insertCategory(kat)
            //var list : MutableList<Category> = db.readCategory()

            //var wynik: String =""
           // db.insertCategory(kat)
           // wynik=db.readCategory()
            //for(i in list.indices )
            //    wynik+= " "+ list[i].ID.toString() + list[i].Kategoria
            //Toast.makeText(this, wynik.toString(), Toast.LENGTH_SHORT).show()
            var sourceLang: String ="auto"
            var targetLang: String ="pl"
            var sourceText: String ="pl"
            external fun encodeURIComponent(str: String): String
            var url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl="+ sourceLang + "&tl=" + targetLang + "&dt=t&q=" + encodeURIComponent(sourceText)
            Executors.newSingleThreadExecutor().execute({
                val json = URL(url).readText()
               // simpleTextView.post { simpleTextView.text = json }
                Toast.makeText(this, json, Toast.LENGTH_SHORT).show()
            })


        }
        button.text= getString(R.string.LAbutton)
    }
}
