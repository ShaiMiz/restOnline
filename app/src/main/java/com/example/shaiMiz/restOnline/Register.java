package com.example.shaiMiz.restOnline;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
    EditText firstName, lastName, email, Password;
    Button btnRegister;
    String URL = "http://192.168.1.59/php/register.php";
    JSONParser jsonParser = new JSONParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName =  findViewById(R.id.firstNameField);
        lastName = findViewById(R.id.lastNameField);
        email = findViewById(R.id.emailField);
        Password = findViewById(R.id.passwordField);
        btnRegister = findViewById(R.id.finishRegistrationButtonField);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (firstName.getText().toString().trim().equalsIgnoreCase("")) {
                firstName.setError("שדה זה לא יכול להיות ריק");
            }
            else if (lastName.getText().toString().trim().equalsIgnoreCase("")) {
                lastName.setError("שדה זה לא יכול להיות ריק");
            }
            else if (email.getText().toString().trim().equalsIgnoreCase("")) {
                email.setError("שדה זה לא יכול להיות ריק");
            }
            else if (Password.getText().toString().trim().equalsIgnoreCase("")) {
                Password.setError("שדה זה לא יכול להיות ריק");
            }
            else {
                AttemptLogin attemptLogin = new AttemptLogin();
                attemptLogin.execute (firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), Password.getText().toString());
            }
            }
        });
    }

    private class AttemptLogin extends AsyncTask<String, String, JSONObject> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... args) {

            String first_name = args[0];
            String last_name = args[1];
            String email = args[2];
            String password = args[3];
            String flag = null;

            Log.d("ADebugTag", "Value: " + args[0]);
            Log.d("ADebugTag", "Value: " + args[1]);
            Log.d("ADebugTag", "Value: " + args[2]);
            Log.d("ADebugTag", "Value: " + args[3]);

            ArrayList params = new ArrayList();
            params.add(new BasicNameValuePair("first_name", first_name));
            params.add(new BasicNameValuePair("last_name", last_name));
            if(email.length() > 0)
                params.add(new BasicNameValuePair("email", email));
            params.add(new BasicNameValuePair("password", password));
            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);

            flag = json.toString();
            Log.d("ADebugTag", "Value: " +flag);

            if (flag.contains("Successfully registered the user"))  {
                startActivity(new Intent(Register.this, MainActivity.class));
            }

            return json;
        }

        protected void onPostExecute(JSONObject result) {
            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}