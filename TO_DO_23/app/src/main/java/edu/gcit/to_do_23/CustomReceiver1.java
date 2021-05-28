package edu.gcit.to_do_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver1 extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String intentAction = intent.getAction();

        if(intentAction !=null)
        {
            String toastmessage = "unkown intent action";

            switch (intentAction)
            {
                case Intent.ACTION_POWER_CONNECTED:
                {
                    toastmessage = "Power connected";
                    break;
                }
                case Intent.ACTION_POWER_DISCONNECTED:
                {
                    toastmessage = "power disconnected";
                    break;
                }
                case ACTION_CUSTOM_BROADCAST:
                {
                    toastmessage = "Custom Broadcast Recevied";
                    break;
                }
            }

            Toast.makeText(context, toastmessage, Toast.LENGTH_SHORT).show();
        }

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}