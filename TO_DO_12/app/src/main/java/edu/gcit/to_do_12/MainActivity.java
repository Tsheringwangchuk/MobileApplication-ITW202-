package edu.gcit.to_do_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String phone = "111-111-1111";
    TextView text1, text2,text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView11);
        text2 = findViewById(R.id.textView22);
        text3 = findViewById(R.id.textView33);

        //Apple

        ImageView imageView=(ImageView) findViewById(R.id.imageView1);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.apple);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);

        //strawberry

        ImageView imageView1=(ImageView) findViewById(R.id.imageView2);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.berry);
        RoundedBitmapDrawable roundedBitmapDrawable1= RoundedBitmapDrawableFactory.create(getResources(), bitmap1);
        roundedBitmapDrawable1.setCircular(true);
        imageView1.setImageDrawable(roundedBitmapDrawable1);

        //orange

        ImageView imageView2=(ImageView) findViewById(R.id.imageView3);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.orange);
        RoundedBitmapDrawable roundedBitmapDrawable2= RoundedBitmapDrawableFactory.create(getResources(), bitmap2);
        roundedBitmapDrawable2.setCircular(true);
        imageView2.setImageDrawable(roundedBitmapDrawable2);



        FloatingActionButton mfab = findViewById(R.id.floatingActionButton);
        mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel://"+phone)));

            }
        });
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void apple(View view) {

        displayToast(getString(R.string.message1));
        text1.setVisibility(View.VISIBLE);

    }
    public void strawberry(View view) {

        displayToast(getString(R.string.message2));
        text2.setVisibility(View.VISIBLE);
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void orange(View view)
    {

        displayToast(getString(R.string.message3));
        text3.setVisibility(View.VISIBLE);
    }
}