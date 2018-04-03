package com.example.patryk.tlumacz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

class AnkoViev : AnkoComponent<AnkoActivity> {

    override fun createView(ui: AnkoContext<AnkoActivity>) = with(ui) {
        verticalLayout {
            lparams(width  = matchParent, height = matchParent)

            val username = editText {
                id = R.id.usernameEditText
                hintResource = R.string.sign_in_username
                textSize = 24f
            }.lparams(width = matchParent, height = wrapContent)

            val translatedText = editText {
                id = R.id.translatedEditText
                //hintResource = R.string.sign_in_username
                textSize = 24f
            }.lparams(width = matchParent, height = wrapContent)

            val button=button {
                id = R.id.signIn_button
                textResource = R.string.signIn_button

                onClick {
                    handleOnSignInButtonPressed(ui,username.text.toString()) }

            }.lparams(width = matchParent, height = wrapContent)
        }



    }
    private fun handleOnSignInButtonPressed(ui: AnkoContext<AnkoActivity>, text:String) {

            ui.owner.translate(text)


    }
}

