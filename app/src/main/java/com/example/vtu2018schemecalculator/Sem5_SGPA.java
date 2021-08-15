package com.example.vtu2018schemecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sem5_SGPA extends AppCompatActivity {
    Button button;
    EditText Subject1, Subject2, Subject3, Subject4, Subject5, Subject6, Lab1, Lab2 , Subject1IA, Subject2IA, Subject3IA, Subject4IA, Subject5IA, Subject6IA, Lab1IA, Lab2IA, Kannada, KannadaIA;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem5__s_g_p);
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
                    if(xx31>60 ||  xx32>60 ||  xx33>60 ||  xx34>60 ||  xx35>60 ||  xx36>60 ||   xxL37>60 || xxL38>60 ||  kannada>60)
                    {
                        Toast.makeText(Sem5_SGPA.this, "INVALID EXTERNAL MARKS!", Toast.LENGTH_LONG).show();
                    }
                    if(xx31IA>40 ||  xx32IA>40 ||  xx33IA>40 ||  xx34IA>40 ||  xx35IA>40 ||  xx36IA>40 ||   xxL37IA>40 || xxL38IA>40 ||  kannadaIA>40)
                    {
                        Toast.makeText(Sem5_SGPA.this, "INVALID INTERNAL MARKS!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double SGPA;
                        SGPA = (double) ((3 * computeGrade(xx31, xx31IA)) +
                                (4 * computeGrade(xx32, xx32IA)) +
                                (4 * computeGrade(xx33, xx33IA)) +
                                (3 * computeGrade(xx34, xx34IA)) +
                                (3 * computeGrade(xx35, xx35IA)) +
                                (3 * computeGrade(xx36, xx36IA)) +
                                (computeGrade(kannada, kannadaIA)) +
                                (2 * computeLabGrade(xxL37, xxL37IA)) +
                                (2 * computeLabGrade(xxL38, xxL38IA)))/25.0;
                        result.setText(String.format("%s", SGPA));
                    }
                }
                else{
                    Toast.makeText(Sem5_SGPA.this, "ALL FIELDS ARE MANDATORY!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public int computeLabGrade(int EXT, int IA)
    {
        if(IA < 20 || EXT < 21)
        {
            return 0;
        }
        else
        {
            return computeGrade(EXT, IA);
        }

    }
    public int computeGrade(int EXT, int IA){
        if(IA < 16 || EXT < 21)
        {
            return 0;
        }
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