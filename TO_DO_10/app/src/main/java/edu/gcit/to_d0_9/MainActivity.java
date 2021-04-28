package edu.gcit.to_d0_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    EditText edit2;
    TextView mresult;
    calculator mcalculator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.firstno);
        edit2 = (EditText)findViewById(R.id.secondno);
        mresult = (TextView) findViewById(R.id.result);

        mcalculator = new calculator();
    }

    public void add(View view) {
        String operand1 = edit1.getText().toString();
        String operand2 = edit2.getText().toString();

        double result = mcalculator.add(Double.valueOf(operand1), Double.valueOf(operand2));
        mresult.setText(String.valueOf(result));

    }

    public void sub(View view) {
        String operand3 = edit1.getText().toString();
        String operand4 = edit2.getText().toString();
        double result = mcalculator.sub(Double.valueOf(operand3), Double.valueOf(operand4));
        mresult.setText(String.valueOf(result));
    }

    public void mul(View view) {
        String operand5 = edit1.getText().toString();
        String operand6 = edit2.getText().toString();
        double result = mcalculator.mul(Double.valueOf(operand5), Double.valueOf(operand6));
        mresult.setText(String.valueOf(result));
    }

    public void div(View view) {
        String operand8 = edit1.getText().toString();
        String operand9 = edit2.getText().toString();
        double result = mcalculator.div(Double.valueOf(operand8), Double.valueOf(operand9));
        mresult.setText(String.valueOf(result));
    }
}