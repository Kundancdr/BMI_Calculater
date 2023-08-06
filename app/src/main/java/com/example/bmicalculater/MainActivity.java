package com.example.bmicalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtweight,edtheightft,edtheightinch;
        Button btncal;
        TextView txtresult;
        LinearLayout llmain;

        edtweight = findViewById(R.id.edtweight);
        edtheightft=findViewById(R.id.edtheightft);
        edtheightinch=findViewById(R.id.edtheightinch);
        btncal=findViewById(R.id.btncal);
        txtresult=findViewById(R.id.txtResult);
        llmain = findViewById(R.id.llmain);

       btncal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              int wt = Integer.parseInt(edtweight.getText().toString());
               int ft = Integer.parseInt(edtheightft.getText().toString());
               int in = Integer.parseInt(edtheightinch.getText().toString());

               int totalIn = ft*12 + in;

               double totalCm = totalIn*2.53;

               double totalM =totalCm/100;

               double bmi = wt/(totalM*totalM);

               if(bmi>25){
                   txtresult.setText("   You are overwight \nyou need to do Exercise");
                   llmain.setBackgroundColor(getResources().getColor(R.color.colourUw));
               }else if(bmi<18) {
                   txtresult.setText("   You are underweight \nYou need to take proper Diet");
                   llmain.setBackgroundColor(getResources().getColor(R.color.colourUw));
               }else{
                   txtresult.setText(" You are healthy \nHave a happy Life");
                   llmain.setBackgroundColor(getResources().getColor(R.color.colourH));
               }

           }
       });
    }
}