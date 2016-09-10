package com.eurybus.exercise02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectButtonClicked(View view){
        //what's our radiogroup?
        RadioGroup rg = (RadioGroup) findViewById(R.id.myRadioGroup);
        int id = rg.getCheckedRadioButtonId();
        //figuring out button
        RadioButton rb = (RadioButton)findViewById(id);
        //Getting radiobutton's text
        String text = (String) rb.getText();
        //Toasting message to screen
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        //This would also work
       // Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }
}
