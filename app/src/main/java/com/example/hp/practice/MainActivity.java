package com.example.hp.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> list = new ArrayList<>();
        Button button = findViewById(R.id.addItem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                list.add(editText.getText().toString());
                intent.putStringArrayListExtra("Item", list);
                startActivity(intent);
            }
        });


    }
}
