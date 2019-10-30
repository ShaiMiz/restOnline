package com.example.shaiMiz.restOnline;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList2 extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] name;
    private final Integer[] imageId;
    private final Integer[] ammount;
    private final Integer[] price;

    public CustomList2(Activity context, String[] name, Integer[] imageId,Integer[] ammount,Integer[] price) {
        super(context, R.layout.list_single2, name);
        this.context = context;
        this.name = name;
        this.imageId = imageId;
        this.ammount=ammount;
        this.price=price;


    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        TextView txtammount = (TextView) rowView.findViewById(R.id.ammount);
        TextView txtprice = (TextView) rowView.findViewById(R.id.price);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(name[position]);
        txtammount.setText(ammount[position]);
        txtprice.setText(price[position]);
       imageView.setImageResource(imageId[position]);

        return rowView;
    }
}