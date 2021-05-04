package edu.gcit.to_do_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent obj = getIntent();
        String message = obj.getStringExtra("message");
        text1 = findViewById(R.id.displymessage);
        text1.setText(message);

        Spinner spinner = findViewById(R.id.label_spinner);
        if(spinner !=null)
        {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.label_spinner, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(spinner!=null)
        {
            spinner.setAdapter(adapter);
        }
    }

    public void onclickedradiobutton(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.radiobutton1:
            {
                if(checked)
                {
                    displayToast(getString(R.string.SameDay));
                }
            }
            break;
            case R.id.radiobutton2:
            {
                if(checked)
                {
                    displayToast(getString(R.string.Nextday));
                }
            }
            break;
            case R.id.radiobutton3:
            {
                if(checked)
                {
                    displayToast(getString(R.string.Pickup));
                }

            }
            break;
        }
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String spinnerLabel = adapterView.getItemAtPosition(position).toString();
      displayToast(spinnerLabel);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
//        displayToast(spinnerLabel);
//
//    }
}