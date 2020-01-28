package com.example.practicalone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Output extends AppCompatActivity {
    TextView OUTPUT_WINDOW;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Intent intent = getIntent();

        String output = intent.getStringExtra("output");
        OUTPUT_WINDOW = findViewById(R.id.opt);
        back = findViewById(R.id.back);
        OUTPUT_WINDOW.setText(output);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
