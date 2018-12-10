package com.example.asus.an_teca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatRoom extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;
    DatabaseReference databaseReference;
    String room_name, user_name;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        textView = (TextView) findViewById(R.id.textViewChat);
        editText = (EditText)findViewById(R.id.editTextChat);
        button = (Button)findViewById(R.id.buttonChat);
        room_name = getIntent().getExtras().get("room_name").toString();
        user_name = getIntent().getExtras().get("user_name").toString();

        databaseReference = FirebaseDatabase.getInstance().getReference().child(room_name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map = new HashMap<String,Object>();
                key = databaseReference.push().getKey();
                databaseReference.updateChildren(map);
                DatabaseReference databaseReference1 = databaseReference.child(key);
                Map<String,Object> map1 = new HashMap<String, Object>();
                map1.put("user_name",user_name);
                map1.put("message",editText.getText().toString());
                databaseReference1.updateChildren(map1);
                editText.setText("");



            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                appen_data(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                appen_data(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    String chat_user_name,chat_user_message;
    private void appen_data(DataSnapshot dataSnapshot){
        Iterator iterator = dataSnapshot.getChildren().iterator();

        while (iterator.hasNext()){
            chat_user_name = (String)((DataSnapshot)iterator.next()).getValue();
            chat_user_message = (String)((DataSnapshot)iterator.next()).getValue();

            textView.append(chat_user_message + " : " +chat_user_name + "\n");


        }
    }

}
