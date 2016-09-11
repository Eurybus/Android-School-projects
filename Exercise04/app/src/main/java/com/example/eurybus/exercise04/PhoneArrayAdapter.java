package com.example.eurybus.exercise04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by eurybus on 9/11/16.
 */
public class PhoneArrayAdapter extends ArrayAdapter<String> {
    //Application context
    private Context context;
    //Phone data (names)
    private ArrayList<String> phones;

    //Let's find out app context
    public PhoneArrayAdapter(Context context, ArrayList<String> phones){
        super(context, R.layout.rowlayout, R.id.textView, phones);
        this.context = context;
        this.phones = phones;
    }
    //Populate every row in ListView
    @Override
    public View getView(int position, View concertView, ViewGroup parent){
        //get row
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        //showing phone name
        TextView tw = (TextView) rowView.findViewById(R.id.textView);
        tw.setText(phones.get(position));
        //Show phone icon
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        switch (phones.get(position)) {
            case "Android": imageView.setImageResource(R.drawable.android); break;
            case "iPhone": imageView.setImageResource(R.drawable.ios); break;
            case "WindowsMobile": imageView.setImageResource(R.drawable.windows); break;
            case "Blackberry": imageView.setImageResource(R.drawable.blackberry); break;
            case "WebOS": imageView.setImageResource(R.drawable.webos); break;
            case "Ubuntu": imageView.setImageResource(R.drawable.ubuntu); break;
        }
        return rowView;
    }
}
