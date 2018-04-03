package com.example.patryk.tlumacz

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import org.w3c.dom.Document
import java.net.URL
import java.net.URLEncoder
import javax.xml.parsers.DocumentBuilderFactory

class AnkoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AnkoViev().setContentView(this)

    }


    fun translate(text:String) {
        doAsync {
            var sourceText: String = text
            var langFromTo: String = "en-pl"
            var KEY : String= "trnsl.1.1.20180331T193159Z.151c13811add400d.58b4031bc68fc3d5b724c3db36ca7e978befcca5"

            var url = "https://translate.yandex.net/api/v1.5/tr/translate?key="+KEY+"&text="+sourceText+"&lang="+langFromTo

            val result: String = URL(url).readText()
            var startIndex: Int =result.indexOf("<text>")+6
            var endIndex:Int=result.indexOf("</text>")
            var text:String= result.substring(startIndex,endIndex)

           // Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            activityUiThread {
                val editText: EditText = findViewById<EditText>(R.id.translatedEditText) as EditText
                    editText.setText(text)
                toast(text)
            }
        }


    }
}

// trnsl.1.1.20180331T193159Z.151c13811add400d.58b4031bc68fc3d5b724c3db36ca7e978befcca5
//key