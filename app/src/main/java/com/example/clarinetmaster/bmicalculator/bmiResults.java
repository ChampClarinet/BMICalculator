package com.example.clarinetmaster.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class bmiResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_results);

        Bundle extras = getIntent().getExtras();
        String h = extras.getString("height");
        String w = extras.getString("weight");

        Human human = new Human(h, w);

        TextView bmiValue = (TextView) findViewById(R.id.bmiValue);
        bmiValue.setText(human.getBMI());
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(getResources().getString(human.getResults()));
    }
}
