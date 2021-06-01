package edu.gcit.to_do_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper myDb;
    EditText eName, eSname, eMarks, eID;
    Button addBtn, viewBtn, updateBtn, deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        eID = findViewById(R.id.edittext1);
        eName = findViewById(R.id.edittext2);
        eSname = findViewById(R.id.edittext3);
        eMarks = findViewById(R.id.edittext4);


        addBtn = findViewById(R.id.addata);
        viewBtn = findViewById(R.id.viewall);
        updateBtn = findViewById(R.id.update);
        deleteBtn = findViewById(R.id.delete);


        addBtn.setOnClickListener(this);
        viewBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addata: {
                boolean isInserted = myDb.insertData(eID.getText().toString(),
                        eName.getText().toString(),
                        eSname.getText().toString(),
                        eMarks.getText().toString());

                if (isInserted == true) {

                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data not inserted and primary key should be unique", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.viewall:
            {
                Cursor res = myDb.getAllData();
                {
                    if(res.getCount() == 0)
                    {
                        showMessage("Error", "Nothing found");
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext())
                    {
                        buffer.append("Student Id: "+ res.getString(0)+"\n");
                        buffer.append("First Name: "+ res.getString(1)+"\n");
                        buffer.append("Last Name: "+ res.getString(2)+"\n");
                        buffer.append("Marks: "+ res.getString(3)+"\n\n");
                    }
                    //show all the data
                    showMessage("List all the students: " , buffer.toString());
                }

            }
            break;
            case R.id.update:
            {
                boolean isUpadte = myDb.updateData(eID.getText().toString(),
                        eName.getText().toString(),
                        eSname.getText().toString(),
                        eMarks.getText().toString());

                if (isUpadte == true)
                {
                    Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Data not update", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            case R.id.delete:
            {
                //one method to delete data
//                boolean isDelete = myDb.deleteData(eID.getText().toString(),
//                        eName.getText().toString(),
//                        eSname.getText().toString(),
//                        eMarks.getText().toString());
//
//                if (isDelete == true)
//                {
//                    Toast.makeText(MainActivity.this, "Data Delete", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(MainActivity.this, "Data not Delete", Toast.LENGTH_SHORT).show();
//                }

                Integer deleteRows = myDb.deleteData(eID.getText().toString());
                {
                  if(deleteRows > 0)
                  {
                      Toast.makeText(MainActivity.this, "Data Delete", Toast.LENGTH_SHORT).show();
                  }
                  else
                  {
                      Toast.makeText(MainActivity.this, "Data not Delete", Toast.LENGTH_SHORT).show();
                  }
                }

            }



        }
    }

    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}