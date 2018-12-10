package com.example.asus.an_teca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About_Activity extends AppCompatActivity {
    private Button Left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_);

        Left = (Button)findViewById(R.id.left);

        Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(About_Activity.this, History_Activity.class));
            }
        });
    }
}
