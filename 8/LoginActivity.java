package com.example.progm8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class LoginActivity extends AppCompatActivity {
    Button btnl_register, btnl_login;EditText l_username, l_password;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper = new DatabaseHelper(this);
        l_username = (EditText)findViewById(R.id.l_username);
        l_password = (EditText)findViewById(R.id.l_password);

        btnl_login = (Button)findViewById(R.id.btnl_login);

        btnl_register = (Button)findViewById(R.id.btnl_register);

        btnl_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnl_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = l_username.getText().toString();
                String password = l_password.getText().toString();

                Boolean checklogin = databaseHelper.CheckLogin(username, password);
                if(checklogin == true){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid username or password",

                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }}