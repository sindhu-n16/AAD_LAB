package com.example.progm8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText e_username, e_password, e_cpassword;
    Button btn_register, btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        e_username = (EditText)findViewById(R.id.e_username);
        e_password = (EditText)findViewById(R.id.e_password);
        e_cpassword = (EditText)findViewById(R.id.e_cpassword);
        btn_register = (Button)findViewById(R.id.btn_register);
        btn_login = (Button)findViewById(R.id.btn_Login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);}});
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e_username.getText().toString();
                String password = e_password.getText().toString();
                String confirm_password = e_cpassword.getText().toString();
                if(username.equals("") || password.equals("") || confirm_password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confirm_password)){
                        Boolean checkusername = databaseHelper.CheckUsername(username);
                        if(checkusername == true){Boolean insert = databaseHelper.Insert(username, password);



                            if(insert == true){
                                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                e_username.setText(username);
                                e_password.setText(password);
                                e_cpassword.setText(confirm_password);
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });}
}