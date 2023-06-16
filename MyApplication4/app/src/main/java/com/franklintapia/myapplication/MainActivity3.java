package com.franklintapia.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView textView1 ;
    TextView textView2 ;
    TextView textView3 ;
    TextView textView4 ;
    TextView textView5 ;
    TextView textView6 ;
    TextView textView7 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textview1);
        textView3 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView4);
        textView6 = findViewById(R.id.textView5);
        textView7 = findViewById(R.id.textView6);


        String Cod = intent.getStringExtra("Texto_Ingresado");
        String NomCom = intent.getStringExtra("Texto_Ingresado1");
        String NomGen = intent.getStringExtra("Texto_Ingresado2");
        String FechaEla = intent.getStringExtra("Texto_Ingresado3");
        String FechaVen = intent.getStringExtra("Texto_Ingresado4");
        String Coste = intent.getStringExtra("Texto_Ingresado5");
        String PVP = intent.getStringExtra("Texto_Ingresado6");

        textView1.setText(Cod);
        textView2.setText(NomCom);
        textView3.setText(NomGen);
        textView4.setText(FechaEla);
        textView5.setText(FechaVen);
        textView6.setText(Coste);
        textView7.setText(PVP);


    }
}