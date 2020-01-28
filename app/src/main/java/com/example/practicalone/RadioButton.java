package com.example.practicalone;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

//practical 2

public class RadioButton implements CompoundButton.OnCheckedChangeListener {
    TextView OUTPUT_WINDOW;
    Context context;
    RadioButton(TextView OUTPUT_WINDOW,Context context){
        this.OUTPUT_WINDOW = OUTPUT_WINDOW;
        this.context = context;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b){
            OUTPUT_WINDOW.setText(compoundButton.getText().toString());
            Toast.makeText(context,compoundButton.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}

