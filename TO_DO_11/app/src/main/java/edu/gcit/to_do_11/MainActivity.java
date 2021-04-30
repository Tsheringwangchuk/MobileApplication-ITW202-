package edu.gcit.to_do_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    String[] colorArray ={"purple_700", "black", "teal_200","purple_500"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        textView = findViewById(R.id.text1);
        //textView.setTextColor(getInt("color"));

    }

    public void change(View view) {
        Random myColor = new Random();
        String colorName = colorArray[myColor.nextInt(3)];
        int colorResource = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
        textView.setTextColor(ContextCompat.getColor(this, colorResource));
    }
}