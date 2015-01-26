package com.kanshu.kanshu;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReadingViewFragment.OnFragmentClickListener} interface
 * to handle interaction events.
 */
public class ReadingViewFragment extends Fragment {


    private OnFragmentClickListener mListener;


    public ReadingViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v  = inflater.inflate(R.layout.fragment_reading_view, container, false);
        final FrameLayout seekBarLayout = ((FrameLayout) v.findViewById(R.id.levelSliderFrame));
        seekBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                s.setAlpha(1.0f);
            }
        });
        seekBarLayout.setAlpha(0.3f);
        ((SeekBar) v.findViewById(R.id.levelSlider)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBarLayout.setAlpha(1.0f);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarLayout.setAlpha(0.3f);
            }
        });
        return v;
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
