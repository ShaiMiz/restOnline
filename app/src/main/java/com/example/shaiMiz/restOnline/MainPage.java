package com.example.shaiMiz.restOnline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    // Creating the menu items for the ListView
    protected void onCreate(Bundle savedInstanceState) {
        final String[] List ={
                "מנות ראשונות",
                "ארוחת בוקר",
                "שתייה קרה",
                "קינוחים",
                "מנות עיקריות",
                "סלטים"
        };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.activity_listview, List);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainPage.this, "You Clicked at " + List[+ position], Toast.LENGTH_SHORT).show();
                if(List[position] == "מנות ראשונות")  {
                    startActivity(new Intent(MainPage.this, appetizers.class));
                }

                if(List[position] == "ארוחת בוקר") {
                   startActivity(new Intent(MainPage.this, breakfast.class));
                }

                if(List[position] == "שתייה קרה") {
                    startActivity(new Intent(MainPage.this, cold_drinks.class));
                }

                if(List[position] == "קינוחים") {
                    startActivity(new Intent(MainPage.this, desserts.class));
                }

                if(List[position] == "מנות עיקריות") {
                    startActivity(new Intent(MainPage.this, main_dish.class));
                }

                if(List[position] == "סלטים") {
                    startActivity(new Intent(MainPage.this, salads.class));
                }
            }
        });
    }
}
