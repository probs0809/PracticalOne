package com.example.practicalone;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView OUTPUT_WINDOW;
    EditText[] NUMBER_VIEW;
    Calculate calculate;
    RadioButton male,female;
    com.example.practicalone.RadioButton radioButton;
    MyCheckBox myCheckBox ;

    CheckBox cb1,cb2,cb3,cb4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NUMBER_VIEW   = new EditText[]{findViewById(R.id.num1),findViewById(R.id.num2)};
        OUTPUT_WINDOW = findViewById(R.id.opt);

        calculate     = new Calculate(NUMBER_VIEW, OUTPUT_WINDOW,MainActivity.this);
        radioButton   = new com.example.practicalone.RadioButton(OUTPUT_WINDOW,getApplicationContext());

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        CheckBox[] cb = {cb1,cb2,cb3,cb4};

        myCheckBox = new MyCheckBox(OUTPUT_WINDOW,getApplicationContext(),cb);

        male    = findViewById(R.id.male);
        female  = findViewById(R.id.female);

//        Radio button
        male.setOnCheckedChangeListener(radioButton);
        female.setOnCheckedChangeListener(radioButton);

//        Check box
        cb1.setOnCheckedChangeListener(myCheckBox);
        cb2.setOnCheckedChangeListener(myCheckBox);
        cb3.setOnCheckedChangeListener(myCheckBox);
        cb4.setOnCheckedChangeListener(myCheckBox);




    }

    public void calculator(View view){
        calculate.calculator(view);
    }
}