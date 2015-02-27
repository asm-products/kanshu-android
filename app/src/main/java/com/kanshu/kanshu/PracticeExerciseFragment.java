package com.kanshu.kanshu;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.edmodo.rangebar.TickedSeekBar;

import java.util.ArrayList;
import java.util.Dictionary;


public class PracticeExerciseFragment extends Fragment {


    private OnFragmentClickListener mListener;
    private ArrayList<String> mAnswers = new ArrayList<String>();
    private int mCorrectAnswer = 0;

    public PracticeExerciseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String[] answers = {"Airplane", "Car", "Children", "Person", "You", "People"}; //test data
        for(int i = 0; i < answers.length; i++)
        {
            mAnswers.add(answers[i]);
        }
        mCorrectAnswer = 4;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_practice_exercise, container, false);
        ListView list = (ListView)v.findViewById(R.id.options_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectAnswer(position);
            }
        });
        list.setAdapter(new ArrayAdapter<String>(this.getActivity(),
                R.layout.practice_exercise_item, mAnswers.toArray(new String[mAnswers.size()])){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    // This a new view we inflate the new layout
                    LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context
                            .LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.practice_exercise_item, parent,
                            false);
                }
                TextView positionText = (TextView)convertView.findViewById(R.id.answer_id);
                positionText.setText((position+1) + ".");
                ((TextView)convertView.findViewById(R.id.answer_text)).setText(mAnswers.get(position));
                return convertView;
            }
        });
        return v;
    }

    private boolean selectAnswer(int position) {
        return false;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onFragmentClick(v);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentClickListener {
        // TODO: Update argument type and name
        public void onFragmentClick(View v);
    }

}