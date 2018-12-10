package com.example.asus.an_teca;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Comment_Activity extends AppCompatActivity {



    private EditText editText;
    private Button button;
    private ListView listView;


    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;

    private DatabaseReference databaseReference;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_);

        editText  = (EditText) findViewById(R.id.edittextRoom);
        button = (Button) findViewById(R.id.buttonAddRoom);
        listView = (ListView)findViewById(R.id.list1);

        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(Comment_Activity.this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        request_userName();

        databaseReference = FirebaseDatabase.getInstance().getReference("Chat Rooms");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map = new HashMap<String, Object>();
                map.put(editText.getText().toString(),"");
                databaseReference.updateChildren(map);
                Toast.makeText(getApplicationContext(),"Chat Room"+ editText.getText().toString()+"Added" , Toast.LENGTH_SHORT).show();
                editText.setText("");

            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Set<String> set = new HashSet<String>();
                Iterator iterator = dataSnapshot.getChildren().iterator();

                while (iterator.hasNext()){
                    set.add(((DataSnapshot)iterator.next()).getKey());
                }
                arrayList.clear();
                arrayList.addAll(set);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Comment_Activity.this,ChatRoom.class);

                intent.putExtra("room_name",((TextView)view).getText().toString());
                intent.putExtra("user_name",username);
                startActivity(intent);
            }
        });

    }

    private void request_userName(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Comment_Activity.this);
        builder.setTitle("Enter your name");
        builder.setCancelable(false);
        final EditText editTextUserName = new EditText(Comment_Activity.this);
        builder.setView(editTextUserName);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                username = editTextUserName.getText().toString();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                request_userName();
            }
        });

        builder.show();
    }
}
