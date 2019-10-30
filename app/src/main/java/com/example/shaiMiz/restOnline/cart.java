package com.example.shaiMiz.restOnline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class cart extends AppCompatActivity {
    static ArrayList<String> items = new ArrayList<String>();
    static ArrayList<Integer> prices = new ArrayList<Integer>();
    static ArrayList<Integer> amount = new ArrayList<Integer>();
    static ArrayList<String> image_name = new ArrayList<String>();
    ListView listView;

    public static void additem (String text,int price,String image) {
        if(!items.contains(text))   {
            items.add(text);
            prices.add(price);
            amount.add(1);
            image_name.add(image);
        }
        else {
            int index = items.indexOf(text);
            int sum = amount.get(index);
            sum+=1;
            amount.set(index,sum);
        }
    }

    public static void deleteitem (String text) {
        if(items.contains(text))  {
            int index = items.indexOf(text);
            amount.remove(index);
            prices.remove(index);
            items.remove(index);
            image_name.remove(index);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        listView = findViewById(R.id.listView);
        //CustomList adapter = new CustomList(cart.this, items.toArray(), image_name.toArray(),amount.toArray(),prices.toArray());
        listView = findViewById(R.id.listView);
        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            }
        });
    }
}

