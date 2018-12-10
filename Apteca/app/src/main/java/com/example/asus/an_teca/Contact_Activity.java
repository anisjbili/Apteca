package com.example.asus.an_teca;

import android.content.Intent;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact_Activity extends AppCompatActivity {

    private Button Left;
    private Button Right;
    private TextView ContactUs;
    private TextView Adresse;
    private TextView AdrMsg;
    private TextView Numero;
    private TextView Horaire;
    private ImageView Direction;
    private ImageView Messenger;
    private ImageView Telephone;
    private ImageView Clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_);

        Left = (Button) findViewById(R.id.button12);
        Right = (Button) findViewById(R.id.button10);
        ContactUs =(TextView) findViewById(R.id.textView2);
        Adresse = (TextView) findViewById(R.id.textView4);
        AdrMsg = (TextView) findViewById(R.id.textView5);
        Numero = (TextView) findViewById(R.id.textView6);
        Horaire = (TextView) findViewById(R.id.textView8);
        Direction = (ImageView) findViewById(R.id.imageView4);
        Messenger = (ImageView) findViewById(R.id.imageView3);
        Telephone = (ImageView) findViewById(R.id.imageView5);
        Clock = (ImageView) findViewById(R.id.imageView6);


    }}
