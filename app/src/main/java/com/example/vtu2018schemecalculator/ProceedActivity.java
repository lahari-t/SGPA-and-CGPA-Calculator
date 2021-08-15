package com.example.vtu2018schemecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProceedActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed);
        button = (Button)findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSemester1();
            }
        });
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSemester2();
            }
        });
        button = (Button)findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSemester3();
            }
        });
        button = (Button)findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSemester4();
            }
        });
        button = (Button)findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSemester5();
            }
        });
        button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSemester6();
            }
        });
    }
    public void openSemester1(){
        Intent intent = new Intent(this, Sem1_SGPA.class);
        startActivity(intent);
    }
    public void openSemester2(){
        Intent intent = new Intent(this, SEM2_SGPA.class);
        startActivity(intent);
    }
    public void openSemester3(){
        Intent intent = new Intent(this, Sem3_SGPA.class);
        startActivity(intent);
    }
    public void openSemester4(){
        Intent intent = new Intent(this, Sem4_SGPA.class);
        startActivity(intent);
    }
    public void openSemester5(){
        Intent intent = new Intent(this, Sem5_SGPA.class);
        startActivity(intent);
    }
    public void openSemester6(){
        Intent intent = new Intent(this, Sem6_SGPA.class);
        startActivity(intent);
    }
}