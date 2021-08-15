package com.example.vtu2018schemecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserCgpa extends AppCompatActivity {
    double cgpa;
    EditText editText;
    FirebaseFirestore fstore;
    private FirebaseAuth auth;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cgpa);
        fstore = FirebaseFirestore.getInstance();
        editText = (EditText)findViewById(R.id.testresult);
        auth = FirebaseAuth.getInstance();
        userID = auth.getCurrentUser().getUid();
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
                    editText.setText(String.format("%s", Rcgpa));
                    Ref.update("CGPA",Rcgpa);
                    Ref.update("PERCENT",percentage);

                }
                else
                {
                    Toast.makeText(UserCgpa.this, "SOME ERROR", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}