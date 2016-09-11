package com.eurybus.exercise2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actv;
    TextView pwField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AutoCompleteTextView
        actv = (AutoCompleteTextView) findViewById(R.id.login_field);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                new String[]{
                        "Pasi","Arto","Sami","Makke","Juhani","Essi"
                });
        actv.setAdapter(aa);

        //PasswordField
        pwField = (TextView) findViewById(R.id.pw_field);
    }

    public void loginButtonPressed(View view){
        Toast.makeText(MainActivity.this,actv.getText() + " " + pwField.getText(),Toast.LENGTH_SHORT).show();
    }
}
