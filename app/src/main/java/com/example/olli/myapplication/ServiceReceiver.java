package com.example.olli.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
        // Launch the specified service when this message is received
//        Intent startServiceIntent = new Intent(context, DownloadServise.class);
//        context.startService(startServiceIntent);
    }
}
