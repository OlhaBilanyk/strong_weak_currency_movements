package com.example.olli.myapplication;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.github.mikephil.charting.charts.BubbleChart;
//import com.github.mikephil.charting.data.BubbleData;
//import com.github.mikephil.charting.data.BubbleDataSet;
//import com.github.mikephil.charting.data.BubbleEntry;
import com.numetriclabz.numandroidcharts.ChartData;
import com.numetriclabz.numandroidcharts.MultiBubbleChart;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBuble.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBuble#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBuble extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static String LOG_TAG = "FragmentBuble";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private View myView;
    MultiBubbleChart bubbleChart = null;
    private OnFragmentInteractionListener mListener;

    public FragmentBuble() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     *               //     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBuble.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBuble newInstance(String param1) {
        FragmentBuble fragment = new FragmentBuble();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_buble, container, false);
        // Inflate the layout for this fragment
        bubbleChart = (MultiBubbleChart) myView.findViewById(R.id.buble_chart);
        Log.d(LOG_TAG, "onCreateView mParam1" + mParam1);
//        Log.d(LOG_TAG, "onCreateView mParam2" + mParam2);
        new DataTask().execute(mParam1);
//        getData(mParam1);
        return myView;
    }

    private void numberOfCallsPerWeekdays(List<String> labels1, List<ChartData> list1, List<ChartData> list2,
                                          List<ChartData> list3, List<ChartData> list4) {
//        bubbleChart = (MultiBubbleChart) myView.findViewById(R.id.buble_chart);
//        List<ChartData> value1 = null;
//        List<ChartData> value2 = null;
//        List<ChartData> value3 = null;
//        List<ChartData> value4 = null;
////        if (list1 != null)
//            value1 = getChartData(list1);
////        if (list2 != null)
//            value2 = getChartData(list2);
////        if (list3 != null)
//            value3 = getChartData(list3);
////        if (list4 != null)
//            value4 = getChartData(list4);
//        Log.d(LOG_TAG, "numberOfCallsPerWeekdays value1.size() " +  value1.size());
////        value1.size();
//        List<ChartData> value = new ArrayList<>();
////        if (value1 != null)
//            value.add(new ChartData(value1));
////        if (value2 != null)
//            value.add(new ChartData(value2));
////        if (value3 != null)
//            value.add(new ChartData(value3));
////        if (value4 != null)
//            value.add(new ChartData(value4));
//
//        bubbleChart.setData(value);
//        List<String> legends = new ArrayList<>();
//        legends.add("M15");
//        legends.add("H1");
//        legends.add("H4");
//        legends.add("D1");
//        bubbleChart.setLegends(legends);
//
//
//        List<String> h_lables = new ArrayList<>();
//        for (int l = 0; l > labels1.size(); l++) {
//            h_lables.add(labels1.get(l));
//
//        }
//
//
//        bubbleChart.setHorizontal_label(h_lables);
//
//        bubbleChart.setGesture(true);
//        List<BubbleEntry> value1 = null;
//        List<BubbleEntry> value2 = null;
//        List<BubbleEntry> value3 = null;
//        List<BubbleEntry> value4 = null;
////        if (list1 != null)
//        value1 = getChartData(list1);
//        BubbleDataSet dataset = new BubbleDataSet(list1, "M15");
////        if (list2 != null)
//        value2 = getChartData(list2);
//        BubbleDataSet dataset2 = new BubbleDataSet(list2, "H1");
////        if (list3 != null)
//        value3 = getChartData(list3);
////        if (list4 != null)
//        value4 = getChartData(list4);
        Log.d(LOG_TAG, "numberOfCallsPerWeekdays list1.size() " + list1.size());
//        value1.size();
//        List<String> h_lables = new ArrayList<>();
//        for (int l = 0; l > labels1.size(); l++) {
//            h_lables.add(labels1.get(l));
//
//        }

//        BubbleData data = new BubbleData(labels1, dataset);
//        BubbleData data1 = new BubbleData(labels1, dataset2);
//        bubbleChart.setData(data);
//
//        List<ChartData> value = new ArrayList<>();
////        if (value1 != null)
//            value.add(new ChartData(list1));
////        if (value2 != null)
//            value.add(new ChartData(value2));
////        if (value3 != null)
//            value.add(new ChartData(value3));
////        if (value4 != null)
//            value.add(new ChartData(value4));
//
        bubbleChart.setData(list1);
        List<String> legends = new ArrayList<>();
        legends.add("M15");
//        legends.add("H1");
//        legends.add("H4");
//        legends.add("D1");
        bubbleChart.setLegends(legends);

//
//
//
//        bubbleChart.setHorizontal_label(h_lables);
//
//        bubbleChart.setGesture(true);

//
////        MultiBubbleChart multiBubbleChart = (MultiBubbleChart) myView.findViewById(R.id.buble_chart);
//
//
//        List<ChartData> value1 = new ArrayList<>();
//
//        value1.add(new ChartData(4f,0.5f));
//        value1.add(new ChartData(12f,1f));
//        value1.add(new ChartData(18f,2f));
//        value1.add(new ChartData(2f,4f));
//        value1.add(new ChartData(12f,5f));
//        value1.add(new ChartData(9f,7f));
//
//        List<ChartData> value2 = new ArrayList<>();
//
//        value2.add(new ChartData(7f, 1.5f)); //values.add(new ChartData(y,x));
//        value2.add(new ChartData(8f, 10f));
//        value2.add(new ChartData(10f, 5f));
//        value2.add(new ChartData(13.5f, 6.8f));
//        value2.add(new ChartData(15f, 9f));
//
//        List<ChartData> value3 = new ArrayList<>();
//        value3.add(new ChartData(value1));
//        value3.add(new ChartData(value2));
//        value3.add(new ChartData(value1));
//        value3.add(new ChartData(value2));
//        BubbleDataSet dataset = new BubbleDataSet(entries, &quot;# of Calls&quot;);
//        bubbleChart.setData(value3);
//
//        List<String> legends = new ArrayList<>();
//        legends.add("Bubble1");
//        legends.add("Bubble2");
//        bubbleChart.setLegends(legends);
//
//        List<String> h_lables = new ArrayList<>();
//        h_lables.add("0.0");
//        h_lables.add("sun");
//        h_lables.add("mon");
//        h_lables.add("tue");
//        h_lables.add("wed");
//
//        bubbleChart.setHorizontal_label(h_lables);
//
//        bubbleChart.setGesture(true);


    }

    private List<ChartData> getChartData(List<Integer> list1) {
        List<ChartData> value1 = new ArrayList<>();
        int l = list1.size();
        Log.d(LOG_TAG, "getChartData list1.size() " + l);
        for (int i1 = 0; i1 < list1.size(); i1++) {
            value1.add(new ChartData(list1.get(i1).floatValue(), ((float) i1)));
        }
        return value1;
    }


    List<String> keys = new ArrayList<>();
    List<ChartData> valuesM15 = new ArrayList<>();
    List<ChartData> valuesH1 = new ArrayList<>();
    List<ChartData> valuesH4 = new ArrayList<>();
    List<ChartData> valuesD1 = new ArrayList<>();
//  List<Integer> valuesM15 = new ArrayList<>();
//    List<Integer> valuesH1 = new ArrayList<>();
//    List<Integer> valuesH4 = new ArrayList<>();
//    List<Integer> valuesD1 = new ArrayList<>();
//    int valuesM15[];
//    int valuesH1 [];
//    int valuesH4 [];
//    int values_D1[];


    private class DataTask extends AsyncTask<String, String, Void> {


        protected Void doInBackground(String... params) {


            try {
                getData(params[0]);


            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }
    }

    void getData(String string) {

        keys = new ArrayList<>();
        valuesM15 = new ArrayList<>();
        valuesH1 = new ArrayList<>();
        valuesH4 = new ArrayList<>();
        valuesD1 = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(string);
            String res[] = new String[]{"M15", "H1", "H4", "D1"};
            for (int m = 0; m < res.length; m++) {
                JSONArray arr = object.getJSONArray(res[m]);
                Log.d(LOG_TAG, "DataTask mParam1" + mParam1);
                int l = arr.length();
                if (l > 0) {
                    for (int i = 0; i < l; i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        keys.add(obj.getString("Key"));
                        switch (res[m]) {
                            case "M15":
                                valuesM15.add(new ChartData((float) (obj.getInt("Value")/25), ((float) i)));
                                break;
                            case "H1":
                                valuesH1.add(new ChartData((float) obj.getInt("Value"), ((float) i)));
                                break;
                            case "H4":
                                valuesH4.add(new ChartData((float) obj.getInt("Value"), ((float) i)));
                                break;
                            case "D1":
                                valuesD1.add(new ChartData((float) obj.getInt("Value"), ((float) i)));
                                break;
                        }


                    }

                }
            }
            numberOfCallsPerWeekdays(keys, valuesM15, valuesH1, valuesH4, valuesD1);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
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
