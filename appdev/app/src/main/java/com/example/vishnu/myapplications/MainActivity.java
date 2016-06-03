package com.example.vishnu.myapplications;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    TextView total;
    RelativeLayout bgcolor;

    int count = 0;



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("times",count);

        super.onSaveInstanceState(savedInstanceState);
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences valu = getSharedPreferences("counter val",0);
        count= valu.getInt("savedcount",0);

        total = (TextView)findViewById(R.id.total);
        total.setText(Integer.toString(count));

        if (savedInstanceState != null) {
            // Restore value of members from saved state

            count = savedInstanceState.getInt("times");


            total.setText(Integer.toString(count));

        }

        bgcolor = (RelativeLayout)findViewById(R.id.bgcolor) ;
        bgcolor.setBackgroundColor(Color.rgb(100*(count+500),200*count,300*count));


        Button calcBtn = (Button)findViewById(R.id.calcBtn);
        Button resetBtn = (Button)findViewById(R.id.reset);


        resetBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                total.setText("0");
                count=0;
                bgcolor.setBackgroundColor(Color.rgb(100*(count+500),200*count,300*count));
                SharedPreferences value = getSharedPreferences("counter val", MODE_PRIVATE);
                SharedPreferences.Editor editor = value.edit();
                editor.putInt("savedcount",count);
                editor.apply();
            }
        });
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                total.setText(Integer.toString(++count));
                bgcolor.setBackgroundColor(Color.rgb(100*(count+500),200*count,300*count));
                SharedPreferences value = getSharedPreferences("counter val", MODE_PRIVATE);
                SharedPreferences.Editor editor = value.edit();
                editor.putInt("savedcount",count);
                editor.apply();

            }
        }





        );




    }









}
