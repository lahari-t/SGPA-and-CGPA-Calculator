package com.example.vtu2018schemecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserViewMarksActivity extends AppCompatActivity {
    Button button;
    TextView s1,s2,s3,s4,s5,s6,s7,s8,cg,per;
    FirebaseFirestore fstore;
    private FirebaseAuth auth;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view_marks);
        button = (Button)findViewById(R.id.button13);
        s1 = (TextView)findViewById(R.id.sem11);
        s2 = (TextView)findViewById(R.id.sem21);
        s3 = (TextView)findViewById(R.id.sem31);
        s4 = (TextView)findViewById(R.id.sem41);
        s5 = (TextView)findViewById(R.id.sem51);
        s6 = (TextView)findViewById(R.id.sem61);
        s7 = (TextView)findViewById(R.id.sem71);
        s8 = (TextView)findViewById(R.id.sem81);
        cg = (TextView)findViewById(R.id.cgpa2);
        per = (TextView)findViewById(R.id.percentage2);
        auth = FirebaseAuth.getInstance();
        userID = auth.getCurrentUser().getUid();
        DocumentReference Ref = FirebaseFirestore.getInstance().collection("Users").document(userID);
        Ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    double sem1 = documentSnapshot.getDouble("SEM1");
                    double sem2 = documentSnapshot.getDouble("SEM2");
                    double sem3 = documentSnapshot.getDouble("SEM3");
                    double sem4 = documentSnapshot.getDouble("SEM4");
                    double sem5 = documentSnapshot.getDouble("SEM5");
                    double sem6 = documentSnapshot.getDouble("SEM6");
                    double sem7 = documentSnapshot.getDouble("SEM7");
                    double sem8 = documentSnapshot.getDouble("SEM8");
                    double cgpa = documentSnapshot.getDouble("CGPA");
                    double percentage = documentSnapshot.getDouble("PERCENT");
                    s1.setText(String.format("%s", sem1));
                    s2.setText(String.format("%s", sem2));
                    s3.setText(String.format("%s", sem3));
                    s4.setText(String.format("%s", sem4));
                    s5.setText(String.format("%s", sem5));
                    s6.setText(String.format("%s", sem6));
                    s7.setText(String.format("%s", sem7));
                    s8.setText(String.format("%s", sem8));
                    cg.setText(String.format("%s", cgpa));
                    per.setText(String.format("%s", percentage));

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserViewMarksActivity.this, UserAddMarks.class);
                startActivity(intent);
            }
        });

    }

}