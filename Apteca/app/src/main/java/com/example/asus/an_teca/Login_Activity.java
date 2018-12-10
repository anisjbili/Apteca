package com.example.asus.an_teca;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private Button SignIn;
    private ImageView anteca;
    private Button NotRegistered;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);


        progressDialog= new ProgressDialog(this);
        anteca = (ImageView) findViewById(R.id.antecan);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),Anais_Activity.class));

        }

        email = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);
        SignIn = (Button) findViewById(R.id.button17);

        NotRegistered = (Button) findViewById(R.id.button18);

        SignIn.setOnClickListener(this);
        NotRegistered.setOnClickListener(this);

    }

    private void userLogin(){
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if(TextUtils.isEmpty(Email)){
            //email is empty
            Toast.makeText(this, "Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(Password)){
            //password empty
            Toast.makeText(this, "Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Signing In...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();

                    if(task.isSuccessful()){
                        //start the profile activity
                        finish();
                        startActivity(new Intent(getApplicationContext(),History_Activity.class));

                    }

                    }
                });

    }


    @Override
    public void onClick(View v) {
        if(v == SignIn){
           userLogin();
        }

        if(v == NotRegistered){
            startActivity(new Intent(this ,MainActivity.class));
        }
    }
}
