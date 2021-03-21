package edu.gcit.to_do_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public static final String EXTRA_MESSAGE = "edu.gcit.to_do_4.MESSAGE";
public static final int Textrequest = 1;
private EditText mEditText;
TextView textV,textv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.t1);

        textV = (TextView)findViewById(R.id.t6);
        textv2 = (TextView)findViewById(R.id.t5);
    }

    public void Send(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        String message = mEditText.getText().toString();
        i.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(i,Textrequest);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Textrequest){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                textv2.setVisibility(View.VISIBLE);
                textV.setText(reply);
            }
        }
    }


}