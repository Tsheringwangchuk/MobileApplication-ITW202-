package edu.gcit.dzongkhaeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void showToast(View view) {
        Toast T = Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT);
        T.show();
    }

    public void count(View view) {
        count++;
        TextView text = (TextView)findViewById(R.id.textView);
        text.setText(""+count);
    }
}