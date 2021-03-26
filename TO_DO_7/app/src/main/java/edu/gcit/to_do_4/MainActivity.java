package edu.gcit.to_do_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    View view;
public static final String EXTRA_MESSAGE = "edu.gcit.to_do_4.MESSAGE";
public static final int TEXT_REQUEST = 1;
public static final String LOG_TAG = MainActivity.class.getSimpleName() ;
    private EditText mEditText;
TextView textV,textv2,texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.acqua);

        mEditText = (EditText) findViewById(R.id.t1);

        textV = (TextView)findViewById(R.id.t6);
        textv2 = (TextView)findViewById(R.id.t5);

        Log.d(LOG_TAG, "onCreated");

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                textv2.setVisibility(View.VISIBLE);

                textV.setText(savedInstanceState.getString("reply_text"));
                textV.setVisibility(View.VISIBLE);
            }
        }
    }

    public void Send(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        String message = mEditText.getText().toString();
        i.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(i, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                textv2.setVisibility(View.VISIBLE);
                textV.setText(reply);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "oneDestroy");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (textv2.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", textV.getText().toString());
        }
    }

    public void increment(View view) {
        count ++;
        texts = (TextView)findViewById(R.id.text0);
        texts.setText(""+count);

    }
}