package org.example.calculator_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.example.calculator_test.databinding.ActivityMainBinding;

import java.lang.invoke.LambdaConversionException;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
    }

    public void numButtonClick(View view){
        String getButtonText = view.getTag().toString();
        if(isFirstInput){
            activityMainBinding.resultTextView.setText(getButtonText);
            activityMainBinding.mathTextView.setText(getButtonText);
            isFirstInput = false;
        }else{
            activityMainBinding.resultTextView.append(getButtonText);
            activityMainBinding.mathTextView.append(getButtonText);
        }

    }





}


