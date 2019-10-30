package com.example.shaiMiz.restOnline;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class salads extends AppCompatActivity {
    ListView listView;
    Integer[] imageId = {
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
            R.drawable.f4,
            R.drawable.f5
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        listView = findViewById(R.id.listView);
        getJSON("http://192.168.1.59/php/gettable6.php");
    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                     }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        final String[] itemName = new String[jsonArray.length()];
        final String[] itemDesc = new String[jsonArray.length()];
        final int[] itemPrice = new int[jsonArray.length()];
        final String[] itemNa = new String[jsonArray.length()];

        // Getting all the items in the sql table
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            itemName[i] = obj.getString("name");
            itemDesc[i] = obj.getString("description");
            itemNa[i] = obj.getString("name");
            itemPrice[i] = obj.getInt("price");
            itemName[i] = "" + itemName[i] + "\n" + "מחיר: " + itemPrice[i] + " ש\"ח " + "\n" + itemDesc[i];
            Log.e("log", "loadIntoListView: "+itemPrice[i]);
            Log.e("log", "loadIntoListView: "+itemName[i]);
        }

        CustomList adapter = new CustomList(salads.this, itemName, imageId);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(salads.this, "You Clicked at " +itemName[+ position], Toast.LENGTH_SHORT).show();
                cart.additem(itemNa[position],itemPrice[position],"b"+position);
            }
        });
    }
}

