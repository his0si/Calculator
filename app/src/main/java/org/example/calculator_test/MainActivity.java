package org.example.calculator_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.example.calculator_test.databinding.ActivityMainBinding;

import java.lang.invoke.LambdaConversionException;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true;
    boolean isOperatorClick = false;
    double resultNumber = 0;
    double inputNumber  = 0;
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
            isFirstInput = false;
            if(operator.equals("=")){
                activityMainBinding.mathTextView.setText(null);
            }
        }else{
            if(activityMainBinding.resultTextView.getText().toString().equals("0")){
                Toast.makeText(this, "0으로 시작되는 숫자는 없습니다.", Toast.LENGTH_SHORT).show();
                isFirstInput = true;
            }else {
                activityMainBinding.resultTextView.append(getButtonText);
            }
        }

    }

    public void allClearButtonClick (View view){
        activityMainBinding.resultTextView.setText("0");
        activityMainBinding.mathTextView.setText("");
        resultNumber = 0;
        operator = "＋";
        isFirstInput = true;
    }

    public void pointButtonClick (View view){
        if(isFirstInput) {
            activityMainBinding.resultTextView.setText("0" + view.getTag().toString());
            isFirstInput = false;
        }else {
            if(activityMainBinding.resultTextView.getText().toString().contains(".")){
                Toast.makeText(this, "이미 소숫점이 존재합니다.", Toast.LENGTH_SHORT).show();
            }else {
                activityMainBinding.resultTextView.append(view.getTag().toString());
            }
        }
    }
    public void operatorClick (View view){
        isOperatorClick = true;
        inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());

        resultNumber = calculator(resultNumber,inputNumber,operator);

        activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
        isFirstInput = true;
        operator = view.getTag().toString();
        activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
    }

    private double calculator(double resultNumber,double inputNumber,String operator) {
        if(operator.equals("=")){
            resultNumber = inputNumber;
        }else if (operator.equals("＋")) {
            resultNumber = resultNumber + inputNumber;
        } else if (operator.equals("－")) {
            resultNumber = resultNumber - inputNumber;
        } else if (operator.equals("×")) {
            resultNumber = resultNumber * inputNumber;
        } else if (operator.equals("÷")) {
            resultNumber = resultNumber / inputNumber;
        }
        return resultNumber;
    }

    public void equalsButtonClick (View view){
        if(isOperatorClick) {

            inputNumber = Double.parseDouble(activityMainBinding.resultTextView.getText().toString());

            resultNumber = calculator(resultNumber, inputNumber, operator);

            activityMainBinding.resultTextView.setText(String.valueOf(resultNumber));
            isFirstInput = true;
            operator = view.getTag().toString();
            activityMainBinding.mathTextView.append(inputNumber + " " + operator + " ");
        }

    }


}


