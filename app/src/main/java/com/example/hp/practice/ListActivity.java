package com.example.hp.practice;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final ListView listView = findViewById(R.id.listView);
        Intent intent = getIntent();
        ArrayList<String> s = intent.getStringArrayListExtra("Item");
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, s);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = listView.getItemAtPosition(i).toString();
                if(text.contains("Item")||text.contains("item"))
                {
                    Intent intent1 = new Intent(ListActivity.this, ShowItem.class);
                    intent1.putExtra("Item", text);
                    startActivity(intent1);
                }
                else
                {
                    if(text.contains("Dial")||text.contains("dial"))
                    {
                        Intent intent1 = new Intent(Intent.ACTION_DIAL);
                        intent1.setData(Uri.parse("tel: "));
                        startActivity(intent1);
                    }
                    else if(text.contains("Browser"))
                    {
                        Intent intent1 = new Intent(Intent.ACTION_VIEW);
                        intent1.setData(Uri.parse("https://www.google.co.in/"));
                        startActivity(intent1);
                    }
                    else if(text.contains("Gmail")||text.contains("gmail"))
                    {
                        Intent intent1 = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                        startActivity(intent1);
                    }
                    else if(text.contains("Gallery"))
                    {
                        Intent intent1 = new Intent(Intent.ACTION_VIEW);
                        intent1.setType("image/*");
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent1);
                    }

                }
            }
        });
    }
}
