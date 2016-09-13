package com.eurybus.classexercise01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class auxialaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxialary);

        //get data from calling intent
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String line = extras.getString("line");

            //Show line in text view
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(line);
        }

    }

    public void ClosePressed(View view){
        Intent intent = new Intent();
        intent.putExtra("result",20);
        setResult(RESULT_OK,intent);
        finish();
    }
}
