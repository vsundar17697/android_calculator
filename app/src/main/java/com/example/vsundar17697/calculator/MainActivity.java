package com.example.vsundar17697.calculator;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity{

    private Button one , two , three ,four , five , six , seven , eight , nine , zero , multiply , add , decimal , percentage , divide , equal , open_p , close_p , clear , subtract;
    private  Button sin , cos , tan , log;
    private TextView expr , answer;

    private String expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        multiply = findViewById(R.id.multiply);
        add = findViewById(R.id.add);
        decimal = findViewById(R.id.decimal);
        percentage = findViewById(R.id.percentage);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);
        open_p = findViewById(R.id.open_p);
        close_p = findViewById(R.id.close_p);
        clear = findViewById(R.id.clear);
        subtract = findViewById(R.id.subtract);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        log = findViewById(R.id.log);

        expr = (TextView) findViewById(R.id.expr);
        answer = (TextView) findViewById(R.id.answer);

        expression = new String();
        expression = "";
        LinearLayout slide_over = (LinearLayout)findViewById(R.id.bottom_sheet);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(slide_over);

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        // set the peek height
        bottomSheetBehavior.setPeekHeight(100);

        // set hideable or not
        bottomSheetBehavior.setHideable(false);

        // set callback for changes
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                System.out.println("State changed");
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        sin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                expression += "sin";
                expr.setText(expression);

            }
        });


        cos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                expression += "cos";
                expr.setText(expression);

            }
        });


        tan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                expression += "tan";
                expr.setText(expression);

            }
        });


        log.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                expression += "log";
                expr.setText(expression);

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    expression += "1";
                    expr.setText(expression);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "2";
                expr.setText(expression);

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "3";
                expr.setText(expression);


            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "4";
                expr.setText(expression);


            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "5";
                expr.setText(expression);


            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "6";
                expr.setText(expression);


            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "7";
                expr.setText(expression);


            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "8";
                expr.setText(expression);


            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "9";
                expr.setText(expression);


            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += "0";
                expr.setText(expression);


            }
        });

        decimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                expression += ".";
                expr.setText(expression);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expression += " * ";
                expr.setText(expression);

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expression += " / ";
                expr.setText(expression);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expression += " + ";

                expr.setText(expression);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression += " - ";
                expr.setText(expression);
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expression += " / ";
                expression += " 100 ";

//                expression += " sin";

                expr.setText(expression);
            }
        });

        open_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expression += " ( ";
                expr.setText(expression);


            }
        });

        close_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expression += " ) ";
                expr.setText(expression);

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = "";
                expr.setText("");
                answer.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expression =expression;
                String ans = PostfixEvaluation.evaluate(expression);
                answer.setText(ans);
                expr.setText(expression);
                expression = "";

            }
        });

    }



}
