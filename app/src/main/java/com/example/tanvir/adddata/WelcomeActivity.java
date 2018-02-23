package com.example.tanvir.adddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView textView1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView1=findViewById(R.id.TextViewwelcomeActivityXmlId);
        button1=findViewById(R.id.ButtonWelcomeActivityXmlId);

        textView1.setText("Welcome\n"+getIntent().getStringExtra("name"));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeActivity.this,ListActivity.class);
                startActivity(i);
            }
        });
    }
}
