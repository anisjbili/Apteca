package com.example.asus.an_teca;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class News_Activity extends AppCompatActivity {



    private DatabaseReference mDatabaseRef;
    private List<ImageUpload> imgList;
    private ListView lv;
    private ImageListAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_);

        imgList = new ArrayList<>();
        lv = (ListView)findViewById(R.id.listViewImage);
        // Show progress dialog during list image loading
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait loading list image...");
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(AddNews_Activity.FB_DATABASE_PATH);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                //Fetch image data from firebase database
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    // ImageUpload class require default constructor
                    ImageUpload img = snapshot.getValue(ImageUpload.class);
                    imgList.add(img);
                }

                //init adapter
                adapter = new ImageListAdapter(News_Activity.this,R.layout.image_item,imgList);
                //set adapter for listview
                lv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
