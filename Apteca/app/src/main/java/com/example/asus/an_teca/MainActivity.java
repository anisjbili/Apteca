package com.example.asus.an_teca;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText NameInput;
    private Button Register;
    private EditText Password;
    private TextView Pass;
    private TextView Nom;
    private Button AlreadyRegistered;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private ImageView anteca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        anteca = (ImageView) findViewById(R.id.antecan);
        Register = (Button) findViewById(R.id.register_button);
       NameInput = (EditText) findViewById(R.id.editText);
       Password = (EditText) findViewById(R.id.editText5);
        AlreadyRegistered = (Button) findViewById(R.id.button16);

        Register.setOnClickListener(this);
        AlreadyRegistered.setOnClickListener(this);

    }

    private void registerUser(){
        String email = NameInput.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password empty
            Toast.makeText(this, "Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            finish();
                            Intent intent = new Intent(MainActivity.this,UserInformation_Activity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,"Could not register, please try again!",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == Register){
            registerUser();
        }

        if (v == AlreadyRegistered){
            startActivity(new Intent(MainActivity.this,History_Activity.class));
        }
    }
}
