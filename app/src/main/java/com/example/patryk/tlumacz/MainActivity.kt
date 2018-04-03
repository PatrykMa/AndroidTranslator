package com.example.patryk.tlumacz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var polskieSlowo : String =""
    var obceSlowo : String =""
    var randIter: Int = 0
    var displayLanguage: Boolean =false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // text view wyswietlajacy losowe slowo
        val textView_randomWorld: TextView = findViewById<TextView>(R.id.textView_RandomWorld) as TextView

        textView_randomWorld.setOnClickListener {
           displayLanguage=!displayLanguage

            if(displayLanguage)
                textView_randomWorld.text=polskieSlowo
            else
                textView_randomWorld.text=obceSlowo
        }

        // przycisk losujacy
        val button_nextWorld: Button = findViewById<Button>(R.id.button_nextWorld) as Button

        button_nextWorld.setOnClickListener{
            displayLanguage=false
            setRandomWorlds()
            textView_randomWorld.text=obceSlowo


        }
        button_nextWorld.text= getString(R.string.MArand_button)

        // przycisk przechodzacy do nauki
        val button_learn : Button = findViewById<Button>(R.id.MAbutton_learn) as Button

        button_learn.setOnClickListener{
            val intent = Intent(this, AnkoActivity::class.java)
            startActivity(intent)
        }
        button_learn.text= getString(R.string.MAadd_button)
    }



       private fun setRandomWorlds  () {
            var P1 :Array<String>  =arrayOf("jeden", "dwa", "trzy")
            var A1 : Array<String>  =arrayOf("one", "two", "three")
            if(randIter>= P1.size || randIter>= A1.size )
                randIter=0
            polskieSlowo= P1[randIter]
            obceSlowo= A1[randIter]
            randIter++

        }
}
