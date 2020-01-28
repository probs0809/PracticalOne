package com.example.practicalone;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class Calculate implements View.OnClickListener{
    private EditText[] NUMBER_VIEW;
    private TextView OUTPUT_WINDOW;
    private Button bt;
    private DecimalFormat df = new DecimalFormat("0.0000");
    private Handler handler = new Handler(Looper.getMainLooper());
    private Intent intent;
    private Context context;

    Calculate(EditText[] NUMBER_VIEW, TextView OUTPUT_WINDOW,Context context){
        this.NUMBER_VIEW = NUMBER_VIEW;
        this.OUTPUT_WINDOW = OUTPUT_WINDOW;
        this.intent = new Intent(context,Output.class);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        calculator(view);
    }

    void calculator(View view){
        bt = (Button) view;
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if((!NUMBER_VIEW[0].getText().toString().isEmpty() && !NUMBER_VIEW[1].getText().toString().isEmpty())){
                            double first_num   = Double.parseDouble(NUMBER_VIEW[0].getText().toString());
                            double second_num  = Double.parseDouble(NUMBER_VIEW[1].getText().toString());

                            switch(bt.getText().toString()){
                                case "+":
                                    intentChange(df.format(first_num + second_num));
                                    break;
                                case "-":
                                    intentChange(df.format(first_num - second_num));
                                    break;
                                case "x":
                                    intentChange(df.format(first_num * second_num));
                                    break;
                                case "/":
                                    intentChange(df.format(first_num / second_num));
                                    break;
                                case "%":
                                    intentChange(df.format(first_num % second_num));
                                    break;
                                default:
                                    OUTPUT_WINDOW.setText(R.string.operator_not_avail);
                                    intent.putExtra("output",R.string.operator_not_avail);
                                    context.startActivity(intent);
                                    break;
                            }

                        }
                        else {
                            OUTPUT_WINDOW.setText(R.string.please_input_values);
                        }
                    }
                });
            }
        }).start();
    }

    private void intentChange(String value){
        OUTPUT_WINDOW.setText(value);
        intent.putExtra("output",value);
        context.startActivity(intent);
    }
}