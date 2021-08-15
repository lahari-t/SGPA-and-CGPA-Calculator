package com.example.vtu2018schemecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserHomeScreen extends AppCompatActivity {
    Button ComputeMarks1, ViewMarks1, Logout;
    TextView WelcomeMessage;
    Double cgpa;
    FirebaseFirestore fstore;
    private FirebaseAuth auth;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_screen);
        WelcomeMessage = (TextView)findViewById(R.id.WelcomeMessage);
        auth = FirebaseAuth.getInstance();
        userID = auth.getCurrentUser().getUid();
        DocumentReference Ref = FirebaseFirestore.getInstance().collection("Users").document(userID);
        Ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String usn = documentSnapshot.getString("USN");
                    WelcomeMessage.setText("WELCOME " + usn + "!");

                }
            }
        });
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
        DocumentReference Ref = FirebaseFirestore.getInstance().collection("Users").document(userID);
        Ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {
                    double sem1 = documentSnapshot.getDouble("SEM1");
                    double sem2 = documentSnapshot.getDouble("SEM2");
                    double sem3 = documentSnapshot.getDouble("SEM3");
                    double sem4 = documentSnapshot.getDouble("SEM4");
                    double sem5 = documentSnapshot.getDouble("SEM5");
                    double sem6 = documentSnapshot.getDouble("SEM6");
                    double sem7 = documentSnapshot.getDouble("SEM7");
                    double sem8 = documentSnapshot.getDouble("SEM8");
                    if(sem1 != 0 && sem2 != 0 && sem3 != 0 && sem4 != 0 && sem5 != 0)
                    {
                        cgpa = (sem1 * 20 + sem2 * 20 + sem3*24 + sem4 * 24 + sem5 * 25 )/(20 + 20 + 24 + 24 + 25);
                    }
                    else if(sem1 != 0 && sem2 != 0 && sem3 != 0 && sem4 != 0 )
                    {
                        cgpa = (sem1 * 20 + sem2 * 20 + sem3*24 + sem4 * 24  )/(20 + 20 + 24 + 24);
                    }
                    else if(sem1 != 0 && sem2 != 0 && sem3 != 0 )
                    {
                        cgpa = (sem1 * 20 + sem2 * 20 + sem3*24 )/(20 + 20 + 24);
                    }
                    else if(sem1 != 0 && sem2 != 0 )
                    {
                        cgpa = (sem1 * 20 + sem2 * 20 )/(20 + 20);
                    }
                    else if(sem1 != 0 )
                    {
                        cgpa = sem1;
                    }
                    //cgpa = 9.68433;
                    double percentage = (cgpa - 0.75)*10;
                    percentage = Math.round(percentage*100);
                    percentage = percentage/100;
                    double Rcgpa = Math.round((cgpa*1000));
                    Rcgpa = Rcgpa/1000;
                    Ref.update("CGPA",Rcgpa);
                    Ref.update("PERCENT",percentage);

                }
                else
                {
                    Toast.makeText(UserHomeScreen.this, "SOME ERROR", Toast.LENGTH_LONG).show();
                }

            }
        });
        Intent intent = new Intent(this, UserViewMarksActivity.class);
        startActivity(intent);
    }
}