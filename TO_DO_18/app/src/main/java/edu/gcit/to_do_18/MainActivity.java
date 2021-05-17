package edu.gcit.to_do_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //member variables
    private RecyclerView mRecyclerview;
    private ArrayList<sports> msportsData;
    private sportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview = findViewById(R.id.recycleview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        //initialize the arraylist
        msportsData = new ArrayList<>();

        //initialize the adapter and set it with recyclerview
        mAdapter = new sportsAdapter(this, msportsData);
        mRecyclerview.setAdapter(mAdapter);

        //get the data
        initializeData();
    }

private void initializeData()
    {
        //get the items from string
        String[] sportslist = getResources().getStringArray(R.array.sports_title);
        String[] sportsinfo = getResources().getStringArray(R.array.sports_Info);
        TypedArray sportsimage = getResources().obtainTypedArray(R.array.sports_image);

        msportsData.clear();
        //create the arraylist of sports objects with title and info
        for (int i=0; i<sportslist.length;i++)
        {
            msportsData.add(new sports(sportslist[i], sportsinfo[i], sportsimage.getResourceId(i, 0)));
        }
        mAdapter.notifyDataSetChanged();
        sportsimage.recycle();
    }
}