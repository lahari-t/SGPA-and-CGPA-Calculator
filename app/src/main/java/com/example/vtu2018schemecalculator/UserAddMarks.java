package com.example.vtu2018schemecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserAddMarks extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_marks);
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
        button = (Button)findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCGPAView();
            }
        });
    }
    public void openSemester1(){
        Intent intent = new Intent(this, UserSem1.class);
        startActivity(intent);
    }
    public void openSemester2(){
        Intent intent = new Intent(this, UserSem2.class);
        startActivity(intent);
    }
    public void openSemester3(){
        Intent intent = new Intent(this, UserSem3.class);
        startActivity(intent);
    }
    public void openSemester4(){
        Intent intent = new Intent(this, UserSem4.class);
        startActivity(intent);
    }
    public void openSemester5(){
        Intent intent = new Intent(this, UserSem5.class);
        startActivity(intent);
    }
    public void openCGPAView(){

        Intent intent = new Intent(this, UserViewMarksActivity.class);
        startActivity(intent);
    }
}