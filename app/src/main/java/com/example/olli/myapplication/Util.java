package com.example.olli.myapplication;

import android.app.AlertDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import static com.github.mikephil.charting.charts.Chart.LOG_TAG;

/**
 * Created by Olli on 12.11.2017.
 */

public class Util {
    private static String LOG_TAG = "TableFragment";

    public static boolean isOnline(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connectivityManager == null)
                return false;

            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();

            if (netInfo != null && netInfo.isConnectedOrConnecting()
                    && connectivityManager.getActiveNetworkInfo().isAvailable()
                    && connectivityManager.getActiveNetworkInfo().isConnected()) {

                Log.i(LOG_TAG, "isOnline = true");
                return true;
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "isOnline; E: " + e.getMessage());
            return false;
        }
        return false;
    }


    public static void showInforamtionAlterDialog(Context context,
                                                  int titleStringId, int messageSStringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(context.getString(titleStringId))
                .setMessage(context.getString(messageSStringId))
                .setPositiveButton(context.getString(R.string.ok), null).show();

    }



}
