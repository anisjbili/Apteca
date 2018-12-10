package com.example.asus.an_teca;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 28/11/2017.
 */

public class ProductList extends ArrayAdapter<ProductInfo> {

    private Activity context;
    List<ProductInfo> produits;

    public ProductList(Activity context, List<ProductInfo> produits) {
        super(context, R.layout.costumlayout, produits);
        this.context = context;
        this.produits = produits;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.costumlayout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewli);
        TextView textViewprice = (TextView) listViewItem.findViewById(R.id.textView14);

        ProductInfo p = produits.get(position);
        textViewName.setText(p.getName());
        textViewprice.setText(p.getPrice());

        return listViewItem;}
}
