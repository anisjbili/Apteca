package com.example.asus.an_teca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayProd_Activity extends AppCompatActivity {
    DatabaseReference databaseProducts ;
    ListView listviewProducts;
    List<ProductInfo> prouits ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_prod_);

        listviewProducts = (ListView)findViewById(R.id.lv1);
        databaseProducts = FirebaseDatabase.getInstance().getReference("Produits");

        prouits = new ArrayList<>();

        listviewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if( position == 0){
                    startActivity(new Intent(DisplayProd_Activity.this,Aderma_Activity.class));
                }


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                prouits.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    ProductInfo p = postSnapshot.getValue(ProductInfo.class);
                    //adding artist to the list
                    prouits.add(p);
                }

                //creating adapter
                ProductList produitAdapter = new ProductList(DisplayProd_Activity.this, prouits);
                //attaching adapter to the listview
                listviewProducts.setAdapter(produitAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
