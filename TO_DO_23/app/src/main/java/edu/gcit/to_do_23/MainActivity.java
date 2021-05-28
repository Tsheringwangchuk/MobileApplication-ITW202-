package edu.gcit.to_do_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CustomReceiver1 mcustomReceiver1 = new CustomReceiver1();
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);

        //register the receiver
        this.registerReceiver(mcustomReceiver1, filter);


    }
    @Override
    protected void onDestroy() {
        //unregister the receiver
        this.unregisterReceiver(mcustomReceiver1);

        LocalBroadcastManager.getInstance(this).unregisterReceiver(mcustomReceiver1);
        super.onDestroy();
    }
    public void sendCustomBroadcast(View view)
    {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
        LocalBroadcastManager.getInstance(this).registerReceiver(mcustomReceiver1, new IntentFilter(ACTION_CUSTOM_BROADCAST));


        //this.registerReceiver(mcustomReceiver1, customBroadcastIntent);

    }
}