package com.example.nick.yourgrade;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name1");
        String g = intent.getStringExtra("grade");
        TextView v = (TextView) findViewById(R.id.name32);
        TextView vv = (TextView) findViewById(R.id.grade);
        v.setText(name);
        vv.setText(g);


    }
}