package com.example.patryk.tlumacz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class  AddActivity extends Activity {

    //Set context
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//Function for calling executing the Translator Background Task
    void Translate(String textToBeTranslated,String languagePair){
    String z;
    }
}
