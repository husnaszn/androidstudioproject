package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });

        Button testButton = findViewById(R.id.testButton);
        Button disButton = findViewById(R.id.disButton);

        testButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "should be switching", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, activity2.class);
                startActivity(intent);
            }

        });

       disButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (disButton.getVisibility()== View.VISIBLE){
                    disButton.setVisibility(View.GONE);
                } else {
                    disButton.setVisibility(View.VISIBLE);
                }
            }

        });

    }
}