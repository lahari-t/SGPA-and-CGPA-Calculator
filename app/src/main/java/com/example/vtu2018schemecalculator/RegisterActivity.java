package com.example.vtu2018schemecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Edits;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private EditText email, password,confirmPassword;
    private Button register;
    private FirebaseAuth auth;
    FirebaseFirestore fstore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = (EditText)findViewById(R.id.editTextTextEmailAddress);
        password = (EditText)findViewById(R.id.editTextTextPassword);
        confirmPassword = (EditText)findViewById(R.id.editTextTextPassword3);
        register = (Button)findViewById(R.id.button4);
        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_id = email.getText().toString();
                String passwd = password.getText().toString();
                String confirmPasswd = confirmPassword.getText().toString();
                if(TextUtils.isEmpty(email_id) || TextUtils.isEmpty(passwd))
                {
                    Toast.makeText(RegisterActivity.this, "All fields are mandatory!", Toast.LENGTH_LONG).show();
                }
                else if(passwd.length() < 6)
                {
                    Toast.makeText(RegisterActivity.this, "Password is too short", Toast.LENGTH_LONG).show();
                }
                else if(!passwd.equals(confirmPasswd))
                {
                    Toast.makeText(RegisterActivity.this, "Passwords are not matching!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    registerUser(email_id,passwd);
                }
            }
        });
    }
    private void registerUser(String email_id, String passwd)
    {
        String EMAIL = email_id + "@usn.com";
        auth.createUserWithEmailAndPassword(EMAIL,passwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                    userID = auth.getCurrentUser().getUid();
                    DocumentReference documentReference = fstore.collection("Users").document(userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("USN",email_id);
                    user.put("SEM1",0);
                    user.put("SEM2",0);
                    user.put("SEM3",0);
                    user.put("SEM4",0);
                    user.put("SEM5",0);
                    user.put("SEM6",0);
                    user.put("SEM7",0);
                    user.put("SEM8",0);
                    user.put("CGPA",0);
                    user.put("PERCENT",0);
                    documentReference.set(user);
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}