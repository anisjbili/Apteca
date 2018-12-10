package com.example.asus.an_teca;

import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.net.Inet4Address;

public class Anais_Activity extends AppCompatActivity implements View.OnClickListener {


    private Button Produit;
    private Button News;
    private Button Home;
    private Button Comment;
    private Button Parametres;
    private Button Left;
    private Button Right;
    private TextView Aboutus;
    private ImageView AnaisLogo;
    private TextView Def;
    private Button Logout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anais_);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,Login_Activity.class));

        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        Left = (Button) findViewById(R.id.button12);
       Right = (Button) findViewById(R.id.button10);
        News = (Button) findViewById(R.id.button5);
        Produit = (Button) findViewById(R.id.button6);
        Home = (Button) findViewById(R.id.button3);
        Comment = (Button) findViewById(R.id.button);
        Parametres = (Button) findViewById(R.id.button4);
        Aboutus =(TextView) findViewById(R.id.textView);
        AnaisLogo = (ImageView) findViewById(R.id.imageView2);
        Def = (TextView) findViewById(R.id.textView3);
        Logout = (Button) findViewById(R.id.logout);



        Logout.setOnClickListener(this);

        Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HistoryIntent = new Intent(Anais_Activity.this, History_Activity.class);

                startActivity(HistoryIntent);
            }
        });


        Produit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProduitIntent = new Intent(Anais_Activity.this, DisplayProd_Activity.class);
                startActivity(ProduitIntent);
            }
        });

        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewsIntent = new Intent(Anais_Activity.this, News_Activity.class);
                startActivity(NewsIntent);
            }
        });

        Comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CommentIntent = new Intent(Anais_Activity.this, Comment_Activity.class);
                startActivity(CommentIntent);
            }
        });

        Parametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ParametresIntent = new Intent(Anais_Activity.this, Parametres_Activity.class);
                startActivity(ParametresIntent);
            }
        });

        Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Anais_Activity.this,Contact_Activity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == Logout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,Login_Activity.class));
        }
    }
}
