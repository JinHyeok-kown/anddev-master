package com.example.user.anddev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mb1 = null;
    Button mb2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mb1 = findViewById(R.id.M_button1);
        mb2 = findViewById(R.id.M_button2);

        mb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "계산기로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);

            }
        });

        mb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "MP3로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MP3Activity.class);
                startActivity(intent);
            }
        });

    }

}
