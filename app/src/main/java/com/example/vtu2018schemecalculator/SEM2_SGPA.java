package com.example.vtu2018schemecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SEM2_SGPA extends AppCompatActivity {
    Button button;
    EditText Subject1, Subject2, Subject3, Subject4, Subject5, Subject6, Lab1, Lab2 , Subject1IA, Subject2IA, Subject3IA, Subject4IA, Subject5IA, Subject6IA, Lab1IA, Lab2IA;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_e_m2__s_g_p);
        button = (Button)findViewById(R.id.button9);
        Subject1 = (EditText)findViewById(R.id.editTextNumber7);
        Subject2 = (EditText)findViewById(R.id.editTextNumber8);
        Subject3 = (EditText)findViewById(R.id.editTextNumber9);
        Subject4 = (EditText)findViewById(R.id.editTextNumber10);
        Subject5 = (EditText)findViewById(R.id.editTextNumber11);
        Lab1 = (EditText)findViewById(R.id.editTextNumber12);
        Lab2 = (EditText)findViewById(R.id.editTextNumber13);
        Subject6 = (EditText)findViewById(R.id.editTextNumber14);
        Subject1IA = (EditText)findViewById(R.id.editTextNumber);
        Subject2IA = (EditText)findViewById(R.id.editTextNumber2);
        Subject3IA = (EditText)findViewById(R.id.editTextNumber3);
        Subject4IA = (EditText)findViewById(R.id.editTextNumber4);
        Subject5IA = (EditText)findViewById(R.id.editTextNumber5);
        Lab1IA = (EditText)findViewById(R.id.editTextNumber15);
        Lab2IA = (EditText)findViewById(R.id.editTextNumber16);
        Subject6IA = (EditText)findViewById(R.id.editTextNumber17);
        result = (TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((Subject1.getText().toString().length() != 0 && Subject2.getText().toString().length() != 0 && Subject3.getText().toString().length() != 0 && Subject4.getText().toString().length() != 0 && Subject5.getText().toString().length() != 0 && Subject6.getText().toString().length() != 0 && Lab1.getText().toString().length() != 0 && Lab2.getText().toString().length() != 0) &&
                        (Subject1IA.getText().toString().length() != 0 && Subject2IA.getText().toString().length() != 0 && Subject3IA.getText().toString().length() != 0 && Subject4IA.getText().toString().length() != 0 && Subject5IA.getText().toString().length() != 0 && Subject6IA.getText().toString().length() != 0 && Lab1IA.getText().toString().length() != 0 && Lab2IA.getText().toString().length() != 0))
                {
                    int xx11 = Integer.parseInt(Subject1.getText().toString());
                    int xx12 = Integer.parseInt(Subject2.getText().toString());
                    int xx13 = Integer.parseInt(Subject3.getText().toString());
                    int xx14 = Integer.parseInt(Subject4.getText().toString());
                    int xx15 = Integer.parseInt(Subject5.getText().toString());
                    int eng1 = Integer.parseInt(Subject6.getText().toString());
                    int xxL16 = Integer.parseInt(Lab1.getText().toString());
                    int xxL17 = Integer.parseInt(Lab2.getText().toString());
                    int xx11IA = Integer.parseInt(Subject1IA.getText().toString());
                    int xx12IA = Integer.parseInt(Subject2IA.getText().toString());
                    int xx13IA = Integer.parseInt(Subject3IA.getText().toString());
                    int xx14IA = Integer.parseInt(Subject4IA.getText().toString());
                    int xx15IA = Integer.parseInt(Subject5IA.getText().toString());
                    int eng1IA = Integer.parseInt(Subject6IA.getText().toString());
                    int xxL16IA = Integer.parseInt(Lab1IA.getText().toString());
                    int xxL17IA = Integer.parseInt(Lab2IA.getText().toString());
                    if(xx11>60 ||  xx12>60 ||  xx13>60 ||  xx14>60 ||  xx15>60 ||  xxL16>60 ||   xxL17>60 ||  eng1>60)
                    {
                        Toast.makeText(SEM2_SGPA.this, "INVALID EXTERNAL MARKS!", Toast.LENGTH_LONG).show();
                    }
                    if(xx11IA>40 ||  xx12IA>40 ||  xx13IA>40 ||  xx14IA>40 ||  xx15IA>40 ||  xxL16IA>40 ||   xxL17IA>40 ||  eng1IA>40)
                    {
                        Toast.makeText(SEM2_SGPA.this, "INVALID INTERNAL MARKS!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        double SGPA;
                        SGPA = (double) ((4 * computeGrade(xx11, xx11IA)) +
                                (4 * computeGrade(xx12, xx12IA)) +
                                (3 * computeGrade(xx13, xx13IA)) +
                                (3 * computeGrade(xx14, xx14IA)) +
                                (3 * computeGrade(xx15, xx15IA)) +
                                (computeGrade(eng1, eng1IA)) +
                                (computeLabGrade(xxL16, xxL16IA)) +
                                (computeLabGrade(xxL17, xxL17IA)))/20.0;
                        result.setText(String.format("%s", SGPA));
                    }
                }
                else{
                    Toast.makeText(SEM2_SGPA.this, "ALL FIELDS ARE MANDATORY!", Toast.LENGTH_LONG).show();
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