package com.example.vtu2018schemecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserSem4 extends AppCompatActivity {
    Button button;
    EditText Subject1, Subject2, Subject3, Subject4, Subject5, Subject6, Lab1, Lab2 , Subject1IA, Subject2IA, Subject3IA, Subject4IA, Subject5IA, Subject6IA, Lab1IA, Lab2IA, Kannada, KannadaIA;
    TextView result;
    FirebaseFirestore fstore;
    FirebaseAuth auth;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sem4);
        button = (Button)findViewById(R.id.button9);
        Subject1 = (EditText)findViewById(R.id.editTextNumber7);
        Subject2 = (EditText)findViewById(R.id.editTextNumber8);
        Subject3 = (EditText)findViewById(R.id.editTextNumber9);
        Subject4 = (EditText)findViewById(R.id.editTextNumber10);
        Subject5 = (EditText)findViewById(R.id.editTextNumber11);
        Subject6 = (EditText)findViewById(R.id.editTextNumber12);
        Lab1 = (EditText)findViewById(R.id.editTextNumber13);
        Lab2 = (EditText)findViewById(R.id.editTextNumber14);
        Kannada = (EditText)findViewById(R.id.editTextNumber18);
        Subject1IA = (EditText)findViewById(R.id.editTextNumber);
        Subject2IA = (EditText)findViewById(R.id.editTextNumber2);
        Subject3IA = (EditText)findViewById(R.id.editTextNumber3);
        Subject4IA = (EditText)findViewById(R.id.editTextNumber4);
        Subject5IA = (EditText)findViewById(R.id.editTextNumber5);
        Subject6IA = (EditText)findViewById(R.id.editTextNumber15);
        Lab1IA = (EditText)findViewById(R.id.editTextNumber16);
        Lab2IA = (EditText)findViewById(R.id.editTextNumber6);
        KannadaIA = (EditText)findViewById(R.id.editTextNumber17);
        result = (TextView)findViewById(R.id.textView);
        fstore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((Subject1.getText().toString().length() != 0 && Subject2.getText().toString().length() != 0 && Subject3.getText().toString().length() != 0 && Subject4.getText().toString().length() != 0 && Subject5.getText().toString().length() != 0 && Subject6.getText().toString().length() != 0 && Lab1.getText().toString().length() != 0 && Lab2.getText().toString().length() != 0 && Kannada.getText().toString().length() != 0) &&
                        (Subject1IA.getText().toString().length() != 0 && Subject2IA.getText().toString().length() != 0 && Subject3IA.getText().toString().length() != 0 && Subject4IA.getText().toString().length() != 0 && Subject5IA.getText().toString().length() != 0 && Subject6IA.getText().toString().length() != 0 && Lab1IA.getText().toString().length() != 0 && Lab2IA.getText().toString().length() != 0 && KannadaIA.getText().toString().length() != 0))
                {
                    int xx31 = Integer.parseInt(Subject1.getText().toString());
                    int xx32 = Integer.parseInt(Subject2.getText().toString());
                    int xx33 = Integer.parseInt(Subject3.getText().toString());
                    int xx34 = Integer.parseInt(Subject4.getText().toString());
                    int xx35 = Integer.parseInt(Subject5.getText().toString());
                    int xx36 = Integer.parseInt(Subject6.getText().toString());
                    int xxL37 = Integer.parseInt(Lab1.getText().toString());
                    int xxL38 = Integer.parseInt(Lab2.getText().toString());
                    int kannada = Integer.parseInt(Kannada.getText().toString());
                    int xx31IA = Integer.parseInt(Subject1IA.getText().toString());
                    int xx32IA = Integer.parseInt(Subject2IA.getText().toString());
                    int xx33IA = Integer.parseInt(Subject3IA.getText().toString());
                    int xx34IA = Integer.parseInt(Subject4IA.getText().toString());
                    int xx35IA = Integer.parseInt(Subject5IA.getText().toString());
                    int xx36IA = Integer.parseInt(Subject6IA.getText().toString());
                    int xxL37IA = Integer.parseInt(Lab1IA.getText().toString());
                    int xxL38IA = Integer.parseInt(Lab2IA.getText().toString());
                    int kannadaIA = Integer.parseInt(KannadaIA.getText().toString());
                    if(xx31>50 ||  xx32>50 ||  xx33>50 ||  xx34>50 ||  xx35>50 ||  xx36>50 ||   xxL37>50 || xxL38>50 ||  kannada>50)
                    {
                        Toast.makeText(UserSem4.this, "INVALID EXTERNAL MARKS!", Toast.LENGTH_LONG).show();
                    }
                    if(xx31IA>50 ||  xx32IA>50 ||  xx33IA>50 ||  xx34IA>50 ||  xx35IA>50 ||  xx36IA>50 ||   xxL37IA>50 || xxL38IA>50 ||  kannadaIA>50)
                    {
                        Toast.makeText(UserSem4.this, "INVALID INTERNAL MARKS!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double SGPA;
                        SGPA = (double) ((3 * computeGrade(xx31, xx31IA)) +
                                (4 * computeGrade(xx32, xx32IA)) +
                                (3 * computeGrade(xx33, xx33IA)) +
                                (3 * computeGrade(xx34, xx34IA)) +
                                (3 * computeGrade(xx35, xx35IA)) +
                                (3 * computeGrade(xx36, xx36IA)) +
                                (computeGrade(kannada, kannadaIA)) +
                                (2 * computeLabGrade(xxL37, xxL37IA)) +
                                (2 * computeLabGrade(xxL38, xxL38IA)))/24.0;
                        result.setText(String.format("%s", SGPA));
                        double rSGPA = Math.round(SGPA * 100);
                        rSGPA = rSGPA/100;                        userID = auth.getCurrentUser().getUid();
                        DocumentReference Ref = FirebaseFirestore.getInstance().collection("Users").document(userID);
                        Ref.update("SEM4", rSGPA);
                    }
                }
                else{
                    Toast.makeText(UserSem4.this, "ALL FIELDS ARE MANDATORY!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public int computeLabGrade(int EXT, int IA)
    {
//        if(IA < 20 || EXT < 21)
//        {
//            return 0;
//        }

        {
            return computeGrade(EXT, IA);
        }

    }
    public int computeGrade(int EXT, int IA){
//        if(IA < 16 || EXT < 21)
//        {
//            return 0;
//        }
        int marks = IA + EXT;
        if(marks>=90)
        {
            return 10;
        }
        if(marks>=80)
        {
            return 9;
        }
        if(marks>=70)
        {
            return 8;
        }
        if(marks>=60)
        {
            return 7;
        }
        if(marks>=50)
        {
            return 6;
        }
        if(marks>=40)
        {
            return 5;
        }
        return 0;
    }
}