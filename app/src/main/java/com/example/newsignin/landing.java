package com.example.newsignin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class landing extends AppCompatActivity {

    Button button;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    TextView nameText;
    Button not;
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        button=findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();
        nameText = findViewById(R.id.name);
        FirebaseUser user = mAuth.getCurrentUser();
        FirebaseUser userData = FirebaseAuth.getInstance().getCurrentUser();

        not= (Button) findViewById(R.id.button);

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage();
            }
        });

        nameText.setText(userData.getDisplayName());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.getInstance().signOut();
                Log.w("Success","Logged out");


            }
        });

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    Log.w("Success"," out");

                    startActivity(new Intent(landing.this, MainActivity.class));
                }
            }
        };
    }

    public void openPage(){
        Intent intent = new Intent(this, Page.class);
        startActivity(intent);
    }
}
