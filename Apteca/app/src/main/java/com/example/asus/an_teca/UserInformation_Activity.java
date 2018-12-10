package com.example.asus.an_teca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserInformation_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText PhoneNumber;
    private EditText Address;
    private EditText FullName;
    private Button Save;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_);

        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        Address = (EditText) findViewById(R.id.Address);
        FullName = (EditText) findViewById(R.id.FullName);
        Save = (Button) findViewById(R.id.save_button);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();

        Save.setOnClickListener(this);



    }

    private void saveUserInformation(){

        String name = FullName.getText().toString().trim();
        String address = Address.getText().toString().trim();
        String number = PhoneNumber.getText().toString().trim();

        UserInformation userInformation = new UserInformation(name,address,number);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userInformation);
        Toast.makeText(this,"Informations saving...",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {
        if (v== Save){
            saveUserInformation();
            startActivity(new Intent(UserInformation_Activity.this,History_Activity.class));
        }
    }
}
