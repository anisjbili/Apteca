package com.example.asus.an_teca;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Produit_Activity extends AppCompatActivity {

    private Button Produit;
    private Button News;
    private Button Home;
    private Button Comment;
    private Button Parametres;


    EditText editTextName;
    EditText editTextPrice;
    Button Add_Product;
    DatabaseReference databaseProducts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_);

        databaseProducts = FirebaseDatabase.getInstance().getReference("Produits");

        News = (Button) findViewById(R.id.button5);
        Produit = (Button) findViewById(R.id.button6);
        Home = (Button) findViewById(R.id.button3);
        Comment = (Button) findViewById(R.id.button);
        Parametres = (Button) findViewById(R.id.button4);

        editTextPrice = (EditText)findViewById(R.id.priceid);
        editTextName = (EditText)findViewById(R.id.editText6);
        Add_Product = (Button)findViewById(R.id.add);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeIntent = new Intent(Produit_Activity.this, Anais_Activity.class);
                startActivity(HomeIntent);
            }
        });

        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewsIntent = new Intent(Produit_Activity.this, DisplayProd_Activity.class);
                startActivity(NewsIntent);
            }
        });

        Comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CommentIntent = new Intent(Produit_Activity.this, Comment_Activity.class);
                startActivity(CommentIntent);
            }
        });

        Parametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ParametresIntent = new Intent(Produit_Activity.this, Parametres_Activity.class);
                startActivity(ParametresIntent);
            }
        });

        Add_Product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });
    }

    private void addProduct() {
        //getting the values to save
        String name = editTextName.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseProducts.push().getKey();

            //creating an Artist Object
            ProductInfo p  = new ProductInfo(name,price,id);

            //Saving the Artist
            databaseProducts.child(id).setValue(p);

            //setting edittext to blank again
            editTextName.setText("");
            editTextPrice.setText("");
            //displaying a success toast
            Toast.makeText(this, "Product added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
