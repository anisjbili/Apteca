package com.example.asus.an_teca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Parametres_Activity extends AppCompatActivity {



    private Button AjoutProduit;
    private Button AjoutActualité;
    private Button VarierPrix;
    private Button Boite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres_);


        AjoutProduit = (Button)findViewById(R.id.butt_prod);
        AjoutActualité = (Button)findViewById(R.id.butt_act);
        VarierPrix = (Button)findViewById(R.id.butt_price);


        AjoutActualité.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Parametres_Activity.this,AddNews_Activity.class));
            }
        });


        AjoutProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Parametres_Activity.this,Produit_Activity.class));
            }
        });


    }
}
