package com.example.progm7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText et_username, et_password, et_cpassword;
    Button btn_register, btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        et_username = (EditText)findViewById(R.id.reg_username);
        et_password = (EditText)findViewById(R.id.reg_password);
        et_cpassword = (EditText)findViewById(R.id.reg_cpassword);
        btn_register = (Button)findViewById(R.id.regbtn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String confirm_password = et_cpassword.getText().toString();
                if(username.equals("") || password.equals("") || confirm_password.equals("")){
                    Toast.makeText(getApplicationContext(), "Required fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confirm_password)){
                        Boolean checkusername = databaseHelper.CheckUsername(username);
                        if(checkusername == true){Boolean insert = databaseHelper.Insert(username, password);



                            if(insert == true){
                                Toast.makeText(getApplicationContext(), "Registration done", Toast.LENGTH_SHORT).show();
                                et_username.setText(username);
                                et_password.setText(password);
                                et_cpassword.setText(confirm_password);
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Passwords does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });}
}