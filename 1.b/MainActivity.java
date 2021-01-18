package com.e.firstprogram1b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button b;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textview);
        b=(Button)findViewById(R.id.button);
        et=(EditText)findViewById(R.id.edittext);
    }
    public void onClick(View view){
        String st=et.getText().toString();
        tv.setText("Hello"+st);
    }
}
