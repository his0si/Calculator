package org.example.calculator_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.example.calculator_test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
    }

    public void num1Click(View view){
        activityMainBinding.resultTextView.append("1");


    }




}


