package com.example.shaiMiz.restOnline;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    EditText email, password;
    Button btnSignIn;
    String URL = "http://192.168.1.59/php/login.php";
    JSONParser jsonParser = new JSONParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.EmailField);
        password = findViewById(R.id.PassField);
        btnSignIn = findViewById(R.id.LoginBtn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getText().toString().trim().equalsIgnoreCase("")) {
                    email.setError("שדה זה לא יכול להיות ריק");
                }
                else if (password.getText().toString().trim().equalsIgnoreCase("")) {
                    password.setError("שדה זה לא יכול להיות ריק");
                }
                else {
                    AttemptLogin attemptLogin = new AttemptLogin();
                    attemptLogin.execute(email.getText().toString(), password.getText().toString(), "");
                }
            }
        });
    }

    public void onRegisterClick(View view) {
        startActivity(new Intent(Login.this, Register.class));
    }

    private class AttemptLogin extends AsyncTask<String, String, JSONObject> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... args) {
            String email = args[0];
            String password = args[1];
            String flag = null;

            ArrayList params = new ArrayList();
            params.add(new BasicNameValuePair("email", email));
            params.add(new BasicNameValuePair("password", password));

            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);
            flag = json.toString();
            if (flag.contains("Successfully logged in"))  {
                startActivity(new Intent(Login.this, MainPage.class));
            }

            return json;
        }

        protected void onPostExecute(JSONObject result) {
            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(), result.getString("message"), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}