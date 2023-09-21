package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstNumberEditText;
    EditText secondNumberEditText;
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumberEditText = findViewById(R.id.myTextField);
        secondNumberEditText = findViewById(R.id.myTextField1);
    }

    public void addFunction(View view){

        String firstNumberStr = firstNumberEditText.getText().toString();
        String secondNumberStr = secondNumberEditText.getText().toString();


        if (!firstNumberStr.isEmpty() && !secondNumberStr.isEmpty()) {
            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);
            double result = firstNumber + secondNumber;
            goToActivity(result);
        }

    }

    public void subtractFunction(View view){
        String firstNumberStr = firstNumberEditText.getText().toString();
        String secondNumberStr = secondNumberEditText.getText().toString();



        if (!firstNumberStr.isEmpty() && !secondNumberStr.isEmpty()) {

            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);
            double result = firstNumber - secondNumber;
            goToActivity(result);

        }else{
            goToError("Empty Fields");
        }

    }
    public void multiplyFunction(View view){
        String firstNumberStr = firstNumberEditText.getText().toString();
        String secondNumberStr = secondNumberEditText.getText().toString();

        if (!firstNumberStr.isEmpty() && !secondNumberStr.isEmpty()) {
            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);
            double result = firstNumber * secondNumber;
            goToActivity(result);
        }else{
            goToError("Empty Fields");
        }

    }
    public void divideFunction(View view){
        String firstNumberStr = firstNumberEditText.getText().toString();
        String secondNumberStr = secondNumberEditText.getText().toString();

        if (!firstNumberStr.isEmpty() && !secondNumberStr.isEmpty()) {
            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);
            if(secondNumber == 0){
                goToError("Cant Divide by 0");
            }else {
                double result = firstNumber / secondNumber;
                goToActivity(result);
            }

        }else{
            goToError("Empty Fields");
        }
    }

    public void goToActivity(double d){
        Intent intent=new Intent(this, resultScreen.class);
        intent.putExtra("message",Double.toString(d));
        startActivity(intent);
    }
    public void goToError(String s){
        Intent intent=new Intent(this, resultScreen.class);
        intent.putExtra("message",s);
        startActivity(intent);
    }


}