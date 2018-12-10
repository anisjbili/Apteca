package com.example.asus.an_teca;

import android.view.View;
import android.widget.TextView;

/**
 * Created by ASUS on 25/11/2017.
 */

public class MyHolder {

    TextView name;
    TextView price;

    public MyHolder(View itemView){

        name = (TextView) itemView.findViewById(R.id.textViewli);
        price = (TextView)itemView.findViewById(R.id.textView14);
    }
}
