package com.eurybus.exercise2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.login_field);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                new String[]{
                        "Pasi","Arto","Sami","Makke","Juhani","Essi"
                });
        actv.setAdapter(aa);
    }
}
