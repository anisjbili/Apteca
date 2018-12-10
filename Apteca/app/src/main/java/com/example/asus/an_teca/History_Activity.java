package com.example.asus.an_teca;

import android.content.Intent;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class History_Activity extends AppCompatActivity {


    private Button Logout;
    private FirebaseAuth firebaseAuth;
    private Button Produit;
    private Button News;
    private Button Home;
    private Button Comment;
    private Button Parametres;
    private Button Left;
    private Button Right;
    private TextView OurHistory;
    private ImageView log;
    private TextView def;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,Login_Activity.class));

        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        Logout = (Button)findViewById(R.id.button2);
        log = (ImageView)findViewById(R.id.imageView8);
        def = (TextView)findViewById(R.id.def);

        Left = (Button) findViewById(R.id.left);
        Right = (Button) findViewById(R.id.button10);
        News = (Button) findViewById(R.id.button5);
        Produit = (Button) findViewById(R.id.button6);
        Home = (Button) findViewById(R.id.button3);
        Comment = (Button) findViewById(R.id.button);
        Parametres = (Button) findViewById(R.id.button4);
        OurHistory =(TextView) findViewById(R.id.textView2);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == Logout){
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(History_Activity.this,Login_Activity.class));
                }
            }
        });

        Parametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(History_Activity.this,Parametres_Activity.class));
            }
        });
        Produit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(History_Activity.this,DisplayProd_Activity.class));
            }
        });

        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(History_Activity.this,News_Activity.class));
            }
        });

        Comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(History_Activity.this, Comment_Activity.class));
            }
        });


        Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(History_Activity.this,About_Activity.class));
            }
        });
    }
}
