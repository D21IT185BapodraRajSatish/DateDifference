package com.example.datedifference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TextView tv1,tv2,differenceview;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.selectedate1);
        tv2 = findViewById(R.id.selectedate2);
        btn = findViewById(R.id.btncalc);
        differenceview = findViewById(R.id.difference);

        calendar =  Calendar.getInstance();
    }
    public void selectDate1(View v){
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                tv1.setText(i2+"/"+(i1+1)+"/"+i);
                btn.setEnabled(true);
            }
        },day,month,year);
        datePickerDialog.show();
    }
    public void selectDate2(View v){
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                tv2.setText(i2+"/"+(i1+1)+"/"+i);
                btn.setEnabled(true);
            }
        },day,month,year);
        datePickerDialog.show();
    }
    public void btnCalc(View v){




        String s[]=tv1.getText().toString().split("/");
        Integer d1[] = new Integer[3];

        for(int i = 0; i< Arrays.stream(s).count(); i++){
            d1[i] = Integer.parseInt(s[i]);
        }

        s=tv2.getText().toString().split("/");
        Integer d2[] = new Integer[3];

        for(int i = 0; i< Arrays.stream(s).count(); i++){
            d2[i] = Integer.parseInt(s[i]);
        }

        int finalday = Math.abs(d1[0]-d2[0]);
        int finalmonth = Math.abs(d1[1]-d2[1]);
        int finalyear = Math.abs(d1[2]-d2[2]);


        differenceview.setText("Day Difference : "+finalday+"\nMonth Difference : "+finalmonth+"\nYear Difference : "+finalyear);

    }


}