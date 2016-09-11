package com.example.eurybus.exercise03;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMap(View view){
        EditText latitude = (EditText) findViewById(R.id.lat_field);
        EditText longitude = (EditText) findViewById(R.id.long_field);

        String latStr = latitude.getText().toString();
        String lonStr = longitude.getText().toString();

        double lat = Double.parseDouble(latStr);
        double lon = Double.parseDouble(lonStr);

        //Show map
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:"+lat+","+lon));
        startActivity(intent);

    }
}
