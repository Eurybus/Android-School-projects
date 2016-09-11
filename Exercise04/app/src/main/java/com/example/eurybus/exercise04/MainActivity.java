package com.example.eurybus.exercise04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find listview
        ListView listView = (ListView) findViewById(R.id.listView);

        //Generating dummy data
        String[] phones = new String[]{
                "Android","iPhone","WindowsMobile","Blackberry","WebOs","Ubuntu"
        };

        //Adding data to array list
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i< phones.length; i++){
            list.add(phones[i]);
        }
        //Adding data to array adapter
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, list);

        //set Data to ListView with array adapter
        listView.setAdapter(adapter);
    }
}
