package edu.gcit.to_do_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY = "edu.gcit.to_do_4.extra.reply";
    private static final String LOG_TAG = MainActivity2.class.getSimpleName();
    private EditText replyEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        replyEditText = (EditText) findViewById(R.id.t4);
        Log.d(LOG_TAG,"onCreated");


        Intent i = getIntent();
        String message =
                i.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.t3);
        textView.setText(message);
    }

    public void Reply(View view) {
        String reply = replyEditText.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
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

}