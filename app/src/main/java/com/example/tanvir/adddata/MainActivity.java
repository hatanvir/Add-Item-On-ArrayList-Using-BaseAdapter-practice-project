package com.example.tanvir.adddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.TextViewXmlId);
        editText=findViewById(R.id.EditTextXmlId);
        button=findViewById(R.id.ButtonXmlId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
                intent.putExtra("name",string);
                startActivity(intent);
            }
        });
    }
}
