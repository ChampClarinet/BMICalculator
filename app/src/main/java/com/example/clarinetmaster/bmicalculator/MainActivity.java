package com.example.clarinetmaster.bmicalculator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String h;
    String w;
    EditText height;
    EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);

        Button submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            Intent i = new Intent(MainActivity.this, bmiResults.class);
            h = height.getText().toString();
            Log.d("heightValue", h);
            w = weight.getText().toString();
            Log.d("weightValue", w);
            if(h.length() > 0 && w.length() > 0){
                i.putExtra("height", h);
                i.putExtra("weight", w);
                startActivity(i);
            }else{
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle(R.string.error);
                dialog.setMessage(R.string.errMessage);
                dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                    });
                dialog.show();
            }
        }
    }
}
