package com.example.vtu2018schemecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class UserHomeScreen extends AppCompatActivity {
    Button ComputeMarks1, ViewMarks1, Logout;
    EditText WelcomeMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_screen);
        ViewMarks1 = (Button)findViewById(R.id.ViewMarks);
        ComputeMarks1 = (Button)findViewById(R.id.ComputeMarks);
        Logout = (Button)findViewById(R.id.button15);
        ViewMarks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMarksCard();
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(UserHomeScreen.this, "Logout Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(UserHomeScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ComputeMarks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHomeScreen.this, UserAddMarks.class);
                startActivity(intent);
            }
        });
    }
    public void openMarksCard(){
        Intent intent = new Intent(this, UserViewMarksActivity.class);
        startActivity(intent);
    }
}