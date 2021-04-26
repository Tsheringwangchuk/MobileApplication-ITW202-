package edu.gcit.sender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2,edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.editText1);
        edit2 = (EditText) findViewById(R.id.editText2);
        edit3 = (EditText) findViewById(R.id.editText3);

    }

    public void next(View view) {
        String text = edit1.getText().toString();
//        Uri url = Uri.parse(text);
//        Intent ob = new Intent(Intent.ACTION_SEND, url);
//
//        startActivity(Intent.createChooser(Intent.));
        String text1 = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(text1)
                .setChooserTitle("Share With")
                .setText(text)
                .startChooser();
    }

    public void nextweb(View view) {
        String t1 = edit2.getText().toString();
        Uri uri = Uri.parse(t1);
        Intent obj = new Intent(Intent.ACTION_VIEW, uri);
        if(obj.resolveActivity(getPackageManager())!=null)
        {
            startActivity(obj);
        }
        else
        {
            Log.d("msg", "error");
        }
    }

    public void nextlocation(View view) {
        String location = edit3.getText().toString();
        Uri uri1 = Uri.parse("geo:0,0?q="+location);
        Intent obj2= new Intent(Intent.ACTION_VIEW, uri1);
        if(obj2.resolveActivity(getPackageManager())!=null)
        {
            startActivity(obj2);
        }
        else
        {
            Log.d("msg", "error");
        }

    }
}