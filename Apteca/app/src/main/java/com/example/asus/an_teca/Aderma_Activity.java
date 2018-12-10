package com.example.asus.an_teca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Aderma_Activity extends AppCompatActivity {

    private ImageView prod;
    private TextView name;
    private TextView price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aderma_);
        name =(TextView) findViewById(R.id.textView7);
          price=(TextView)findViewById(R.id.textView9);
           prod = (ImageView)findViewById(R.id.imageView7);
    }
}
