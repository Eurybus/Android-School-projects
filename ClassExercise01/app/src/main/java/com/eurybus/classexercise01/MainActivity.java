package com.eurybus.classexercise01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int NEW_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivity(View view){
        //Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
        EditText editText = (EditText)findViewById(R.id.editText);
        String line = editText.getText().toString();
        //Explicit intent
        Intent intent = new Intent(this,auxialaryActivity.class);
        intent.putExtra("line",line);
        startActivity(intent);
    }

    public void startActivityResult(View view){
        Intent intent = new Intent(this,auxialaryActivity.class);
        startActivityForResult(intent,NEW_ACTIVITY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == NEW_ACTIVITY && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            int result = extras.getInt("result");
            Toast.makeText(MainActivity.this, "result = " + result, Toast.LENGTH_SHORT).show();
        }
    }
}
