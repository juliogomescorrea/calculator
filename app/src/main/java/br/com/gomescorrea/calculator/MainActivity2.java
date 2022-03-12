package br.com.gomescorrea.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ScrollView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it = getIntent();

        String history = it.getStringExtra("history");

        TextView strHistory = findViewById(R.id.viewHistory);
        strHistory.setText(history.toString());
        strHistory.setMovementMethod(new ScrollingMovementMethod());

    }

    public void back(View v){
        finish();
    }
}