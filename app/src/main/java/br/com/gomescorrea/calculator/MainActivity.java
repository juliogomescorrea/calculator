package br.com.gomescorrea.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bPoint;
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;

    TextView vDisplay;

    String history = "";
    String historyDisplay = "";

    String number1 = "";
    String number2 = "";
    String result;
    Boolean isOperator = false;
    String lastOperator = "";

    View.OnClickListener btClickListenerNumber = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setNumber(v);
            Log.d("EVT", "AQUI " + history);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = findViewById(R.id.b0);
        b0.setOnClickListener(btClickListenerNumber);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(btClickListenerNumber);
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(btClickListenerNumber);
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(btClickListenerNumber);
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(btClickListenerNumber);
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(btClickListenerNumber);
        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(btClickListenerNumber);
        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(btClickListenerNumber);
        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(btClickListenerNumber);
        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(btClickListenerNumber);
        bPoint = findViewById(R.id.bPoint);
        bPoint.setOnClickListener(btClickListenerNumber);
    }

    public void setNumber(View v){
        Button button = findViewById(v.getId());

        number1 = number1 == "0" ? "" : number1;

        if (!isOperator){
            number1 += button.getText();
        }else{
            number2 += button.getText();
        }

        setDisplay(button.getText().toString());
    }

    public void sum(View v){
        Button button = findViewById(v.getId());
        Log.d("History",number2.toString());
        if (number2 == ""){
            isOperator = true;
        }else{
            setResult(lastOperator);
        }
        lastOperator = "SUM";
        setDisplay(button.getText().toString());
    }

    public void sub(View v){
        Button button = findViewById(v.getId());
        Log.d("History",number2.toString());
        if (number2 == ""){
            isOperator = true;
        }else{
            setResult(lastOperator);
        }
        lastOperator = "SUB";
        setDisplay(button.getText().toString());
    }

    public void mul(View v){
        Button button = findViewById(v.getId());
        Log.d("History",number2.toString());
        if (number2 == ""){
            isOperator = true;
        }else{
            setResult(lastOperator);
        }
        lastOperator = "MUL";
        setDisplay(button.getText().toString());
    }

    public void div(View v){
        Button button = findViewById(v.getId());
        Log.d("History",number2.toString());
        if (number2 == ""){
            isOperator = true;
        }else{
            setResult(lastOperator);
        }
        lastOperator = "DIV";
        setDisplay(button.getText().toString());
    }

    public void equal(View v){
        setResult(lastOperator);
    }

    public void clear(View v){
        result = "";
        number1 = "";
        number2 = "";
        historyDisplay = "";
        isOperator = false;
        lastOperator = "";
        setDisplay("0");
    }

    public void viewHistory(View v){
        Intent it = new Intent(getBaseContext(), MainActivity2.class);
        Log.d("HISTORY", history.toString());
        it.putExtra("history", history.toString());
        startActivity(it);
    }

    public void setDisplay(String value){
        historyDisplay += value;
        vDisplay = findViewById(R.id.vDisplay);
        vDisplay.setText(historyDisplay);
    }

    public void setResult(String operator){
        Float number1F = Float.parseFloat(number1);
        Float number2F = Float.parseFloat(number2);
        Float resultF;
        String operatorStr = "";
        switch (operator){
            case "SUM":
                resultF = (number1F + number2F);
                operatorStr = "+";
                break;
            case "SUB":
                resultF = (number1F - number2F);
                operatorStr = "-";
                break;
            case "MUL":
                resultF = (number1F * number2F);
                operatorStr = "*";
                break;
            case "DIV":
                resultF = (number1F / number2F);
                operatorStr = "/";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        double rest = resultF - Math.floor(resultF);
        if (rest != 0f){
            result = resultF.toString();
        }else{
            result = resultF.toString().replace(".0", "");
        }

        history += number1 + "\n" + operatorStr + " " + number2 + "\n= " + result + "\n---------\n" ;

        number1 = result;
        number2 = "";
        historyDisplay = "";

        Log.d("Result",result.toString());
        setDisplay(result);

        Log.d("History", history.toString());
    }


}