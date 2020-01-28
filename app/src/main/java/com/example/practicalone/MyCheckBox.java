package com.example.practicalone;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


public class MyCheckBox extends RadioButton implements CompoundButton.OnCheckedChangeListener {
    private CheckBox[] cb;
    private Handler handler;

    MyCheckBox(TextView OUTPUT_WINDOW, Context context, CheckBox[] cb){
        super(OUTPUT_WINDOW,context);
        this.cb = cb;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        StringBuilder s = new StringBuilder();
                        for(CheckBox cbox: cb){
                            if (cbox.isChecked()){
                                s.append(" ").append(cbox.getText().toString());
                            }
                        }
                        OUTPUT_WINDOW.setText(s.toString());
                        Toast.makeText(context,s.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

    }


}
