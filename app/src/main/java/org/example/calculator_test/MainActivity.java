package org.example.calculator_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.example.calculator_test.databinding.ActivityMainBinding;

import java.lang.invoke.LambdaConversionException;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    double resultNumber = 0;
    String operator = "＋";

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

    public void operatorClick (View view){
        double inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());

        if(operator.equals("＋")){
            resultNumber = resultNumber + inputNumber;
        }else if(operator.equals("－")){
            resultNumber = resultNumber - inputNumber;
        }else if(operator.equals("×")){
            resultNumber = resultNumber * inputNumber;
        } else if (operator.equals("÷")) {
            resultNumber = resultNumber / inputNumber;
        }

        activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
        isFirstInput = true;
        operator = view.getTag().toString();


    }




}


