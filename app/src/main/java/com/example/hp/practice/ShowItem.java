package com.example.hp.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        Intent intent = getIntent();
        String s = intent.getStringExtra("Item");
        TextView t = findViewById(R.id.textView);
        t.setText(s);
    }
}
