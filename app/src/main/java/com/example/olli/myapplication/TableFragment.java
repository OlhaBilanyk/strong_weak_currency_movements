package com.example.olli.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TableFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableFragment extends Fragment {
    private static String LOG_TAG = "TableFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View myView;
    TableLayout tableLayout;
    private OnFragmentInteractionListener mListener;

    public TableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TableFragment newInstance(String param1, String param2) {
        TableFragment fragment = new TableFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    String[] getStrongWeakData(String string, String key) {


        try {
            JSONObject object = new JSONObject(string);

            JSONArray arr = object.getJSONArray("SymbolIndices");
            int l = arr.length();
            String values[] = new String[l];
            if (l > 0) {
                for (int i = 0; i < l; i++) {
                    JSONObject obj = arr.getJSONObject(i);

                    values[i] = obj.getString(key);


                }
                return values;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    String[] row = {"TimeFrame",  "Strongest", "Weakest", "StrongWeakPair"};
    void rowForm(String s) {
        String strongWeak[] = getStrongWeakData(mParam1, s);
        setValue(s, strongWeak);
//        TextView text = new TextView(getActivity());
//        text.setText(s);
//        text.setTypeface(Typeface.SERIF, Typeface.BOLD);
//        rowTitle.addView(text);
//
//        for (int l = 0; l < strongWeak.length; l++) {
//            TextView textView = new TextView(getActivity());
//            textView.setText(strongWeak[l]);
//            textView.setGravity(Gravity.CENTER_HORIZONTAL);
//            switch (l) {
//                case 0:
//                    row1.addView(textView);
//                    break;
//                case 1:
//                    row2.addView(textView);
//                    break;
//                case 2:
//                    row3.addView(textView);
//                    break;
//                case 3:
//                    row4.addView(textView);
//                    break;
//            }
//        }
    }

    void setValue(String s, String[] arr) {

        TextView text = new TextView(getActivity());
        text.setText(s);
        text.setTypeface(Typeface.SERIF, Typeface.BOLD);
        rowTitle.addView(text);

        for (int l = 0; l < arr.length; l++) {
            TextView textView = new TextView(getActivity());
            textView.setText(arr[l]);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            switch (l) {
                case 0:
                    row1.addView(textView);
                    break;
                case 1:
                    row2.addView(textView);
                    break;
                case 2:
                    row3.addView(textView);
                    break;
                case 3:
                    row4.addView(textView);
                    break;
            }
        }
    }

    TableRow rowTitle;
    TableRow row1;
    TableRow row2;
    TableRow row3;
    TableRow row4;

    void crTable() {
        TableLayout table = new TableLayout(getActivity());

        tableLayout.setStretchAllColumns(true);
        tableLayout.setShrinkAllColumns(true);

        rowTitle = new TableRow(getActivity());
        row1 = new TableRow(getActivity());
        row2 = new TableRow(getActivity());
        row3 = new TableRow(getActivity());
        row4 = new TableRow(getActivity());

        for (int k = 0; k < row.length; k++)
            rowForm(row[k]);


        tableLayout.addView(rowTitle);
        tableLayout.addView(row1);
        tableLayout.addView(row2);
        tableLayout.addView(row3);
        tableLayout.addView(row4);

//        myView.setContentView(table);


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
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_table, container, false);
        tableLayout = (TableLayout) myView.findViewById(R.id.table);
        crTable();
        return myView;
    }


//
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
