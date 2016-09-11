package com.example.eurybus.exercise04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        //ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, list);

        //Custom layout
        //ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.rowlayout,R.id.textView, list);
        //Custom adapter
        PhoneArrayAdapter adapter = new PhoneArrayAdapter(this, list);
        //set Data to ListView with array adapter
        listView.setAdapter(adapter);

        //Item listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Get list row data (Now String as a phone)
                String phone = list.get(position);
                //Create explicit intent
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                //Add data to intent
                intent.putExtra("phone",phone);
                //start a new activity
                startActivity(intent);
            }
        });
    }
}
