package com.example.olli.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public final static int STATUS_FINISH = 200;
    public final static String PARAM_PINTENT = "pendingIntent";
    public final static String PARAM_RESULT = "result";
    public final static int INTERVAL =5*1000;
    private AlarmManager alarm;
    private static String LOG_TAG = "MainActivity";

    //=============
    int visibleChartIndex = 0;
    BarChart barChart = null;

    final int TASK1_CODE = 1;
    TextView textView;
    //==============
    ViewPager pager;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "1");
        tabs = (TabLayout) findViewById(R.id.tabs);
//        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        pager = (ViewPager) findViewById(R.id.pager);

//        textView = (TextView) findViewById(R.id.text);
        String httpsURL = "http://91.194.90.62:20019/fxservice/strongweak";//http://34.197.213.118:20019/fxservice/strongweak";
        tabs.setupWithViewPager(pager);

        alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        numberOfCallsPerWeekdays(null,null);
    }

    private void setupTabIcons() {

//        int[] tabIcons = {
//                R.mipmap.phone_call_all,
//                R.mipmap.phone_call_out,
//                R.mipmap.phone_call_in,
//                R.mipmap.phone_call_missed
//        };

        tabs.getTabAt(0).setText("Home");
        tabs.getTabAt(1).setText("M15");
        tabs.getTabAt(2).setText("H1");
        tabs.getTabAt(3).setText("H4");
        tabs.getTabAt(4).setText("D1");
    }

    Fragment fragment;
    //    ViewPagerAdapter adapter;
    MyAdapter adapter;

    public void setupViewPager(final ViewPager viewPager, String s) {
        String key = "type";
        adapter = new MyAdapter(this.getSupportFragmentManager());
        fragment = TableFragment.newInstance(s,"");
        adapter.addFragment(fragment);
        fragment = BaseFragment.newInstance("M15", s);
        adapter.addFragment(fragment);
        fragment = BaseFragment.newInstance("H1", s);
        adapter.addFragment(fragment);
        fragment = BaseFragment.newInstance("H4", s);
        adapter.addFragment(fragment);
        fragment = BaseFragment.newInstance("D1", s);
        adapter.addFragment(fragment);

        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public static class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        Fragment fragment;

        private String getFragmentTag(int pos) {
            return "android:switcher:" + R.id.pager + ":" + pos;
        }

        @Override
        public int getCount() {
            return 5;
        }

        private final List<Fragment> mFragmentList = new ArrayList<>();

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;//"Child Fragment " + position;
        }

    }

//    private void numberOfCallsPerWeekdays(List<String> labels1, int[] days) {
//        ArrayList<BarEntry> entries = new ArrayList<>();
////        if (days == null) {
////            days = StaticData.barChartDataCache;
////        } else {
////            StaticData.barChartDataCache = days;
////        }
//
//        for (int i = 0; i < days.length; i++) {
//            entries.add(new BarEntry(days[i], i));
//        }
//
//        barChart = (BarChart) findViewById(R.id.barChart);
//        barChart.setVisibility(View.VISIBLE);
//
//        BarDataSet dataSet = new BarDataSet(entries, "number_of_calls_per_day");
////        List<String> labels = Arrays.asList(getResources().getStringArray(R.array.weekdays_array));
//
//        BarData data = new BarData(labels1, dataSet);
//        barChart.setData(data);
////        barChart.setDescription("number_of_calls_per_day");
//        barChart.animateY(5000);
//        barChart.getAxisLeft().setStartAtZero(false);
//        barChart.getAxisRight().setStartAtZero(false);
////        barChart.getAx().setStartAtZero(false);
////        barChart.setPinchZoom(false);
//        barChart.setDrawGridBackground(true);
//        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//
////        Legend l = barChart.getLegend();
////        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
////        l.setForm(Legend.LegendForm.SQUARE);
//////        l.setFormSize(9f);
////        l.setTextSize(11f);
////        l.setXEntrySpace(4f);
//    }

//    List<String> keys = new ArrayList<>();

    //    class StatsAsyncTaskForBarChart extends AsyncTask<String, JSONObject, String> {
//
//
//        List<String> keys = new ArrayList<>();
//        @Override
//        protected JSONObject doInBackground(String... params) {
//            try {
//                JSONObject res = new JSONObject(params[0]);
////                List<String> elements = new ArrayList<>();
////                String name;
////                       /*Number of calls per weekday*/
////                List<Call> calls = CallLogManager.getCallLogs(StatsActivity.this);
////                int days[] = new int[7];
////                for (Call call : calls) {
////                    int day = call.getCallDayTime().getDay();
////                    days[day]++;
////                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return res;//days;
//        }
//
//        @Override
//        protected void onPostExecute(JSONObject days) {
//            super.onPostExecute("");
//            getData(days);
////            numberOfCallsPerWeekdays(days);
//        }
//
//        void getData(JSONObject object, String key) {
//            keys = new ArrayList<>();
//            try {
//                JSONArray arr = object.getJSONArray(key);
//                int l = arr.length();
//                int values[] = new int[l];
//                if (l > 0) {
//                    for (int i = 0; i < l; i++) {
//                        JSONObject obj = arr.getJSONObject(i);
//                        keys.add(obj.getString("Key"));
//
//                        values[i] = obj.getInt("Value");
//
//                    }
//                    numberOfCallsPerWeekdays(keys,values);
//                }
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//
//    }
//    void getData(String string, String key) {
//
//        keys = new ArrayList<>();
//        try {
//            JSONObject object = new JSONObject(string);
//
//            JSONArray arr = object.getJSONArray(key);
//            int l = arr.length();
//            int values[] = new int[l];
//            if (l > 0) {
//                for (int i = 0; i < l; i++) {
//                    JSONObject obj = arr.getJSONObject(i);
//                    keys.add(obj.getString("Key"));
//
//                    values[i] = obj.getInt("Value");
//
//                }
//                numberOfCallsPerWeekdays(keys, values);
//            }
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    void startNewService() {
        Calendar cal = Calendar.getInstance();
        PendingIntent pi;
        Intent intent;
        Intent si = new Intent();
        pi = createPendingResult(1, si, 0);
        intent = new Intent(this, DownloadServise.class)
                .putExtra(PARAM_PINTENT, pi);


        startService(intent);

        pi = createPendingResult(1, si, 0);

        Intent intent1 = new Intent(MainActivity.this, DownloadServise.class);
        intent1.putExtra(PARAM_PINTENT, pi);
        PendingIntent pintent = PendingIntent.getService(MainActivity.this, 0, intent1, PendingIntent.FLAG_CANCEL_CURRENT);


        alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  INTERVAL , pintent);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, "requestCode = " + requestCode + ", resultCode = "
                + resultCode);

        if (resultCode == STATUS_FINISH) {
            String result = data.getStringExtra(PARAM_RESULT);
            switch (requestCode) {
                case TASK1_CODE:
                    Log.d(LOG_TAG, " TASK1_CODE  " + result);
                    setupViewPager(pager, result);
                    setupTabIcons();
//                    getData(result, "D1");
//                    textView.setText("Task1 finish, result = " + result);
                    break;

            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "2");
        startNewService();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "3");
    }


}

