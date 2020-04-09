package com.example.newsignin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Page extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        b1 = (Button) findViewById(R.id.not);
        b2 = (Button) findViewById(R.id.ration);
        b3 = (Button) findViewById(R.id.health);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivity();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRation();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHealth();
            }
        });
    }

    public void openMainActivity(){

        Intent intent = new Intent(this, notify.class);
        startActivity(intent);

    }

    public void openRation(){

        Intent intent = new Intent(this, ration.class);
        startActivity(intent);


    }


    public void openHealth(){

        Intent intent = new Intent(this, health.class);
        startActivity(intent);


    }



}
