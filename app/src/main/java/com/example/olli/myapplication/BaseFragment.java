package com.example.olli.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BaseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaseFragment extends Fragment {
    private static String LOG_TAG = "BaseFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    BarChart barChart = null;
    private OnFragmentInteractionListener mListener;
    View myView;

    public BaseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BaseFragment newInstance(String param1, String param2) {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_base, container, false);
        // Inflate the layout for this fragment

        barChart = (BarChart) myView.findViewById(R.id.barChart);
        Log.d(LOG_TAG, "onCreateView mParam1" + mParam1);
        Log.d(LOG_TAG, "onCreateView mParam2" + mParam2);

        getData(mParam2, mParam1);
        return myView;//inflater.inflate(R.layout.fragment_base, container, false);

    }

    private void numberOfCallsPerWeekdays(List<String> labels1, int[] days) {
        ArrayList<BarEntry> entries = new ArrayList<>();
//        if (days == null) {
//            days = StaticData.barChartDataCache;
//        } else {
//            StaticData.barChartDataCache = days;
//        }

        for (int i = 0; i < days.length; i++) {
            entries.add(new BarEntry(days[i], i));
        }

        barChart.setVisibility(View.VISIBLE);

        BarDataSet dataSet = new BarDataSet(entries, "");
//        List<String> labels = Arrays.asList(getResources().getStringArray(R.array.weekdays_array));

        BarData data = new BarData(labels1, dataSet);
        barChart.setData(data);
//        barChart.getAxisLeft().setStartAtZero(false);
//        barChart.getAxisRight().setStartAtZero(false);
        barChart.setDrawGridBackground(false);
        dataSet.setColor(getResources().getColor(R.color.bar_color));
//        dataSet.setColor(R.color.accent_two);
    }

    List<String> keys = new ArrayList<>();

    void getData(String string, String key) {

        keys = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(string);

            JSONArray arr = object.getJSONArray(key);
            int l = arr.length();
            int values[] = new int[l];
            if (l > 0) {
                for (int i = 0; i < l; i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    keys.add(obj.getString("Key"));

                    values[i] = obj.getInt("Value");

                }
                numberOfCallsPerWeekdays(keys, values);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
