package com.kanshu.kanshu;

import android.animation.LayoutTransition;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.edmodo.rangebar.TickedSeekBar;
import com.kanshu.kanshu.adapter.ReadingViewAdapter;
import com.kanshu.kanshu.model.ReadingChunk;

import java.util.ArrayList;
import java.util.List;


public class ReadingViewFragment extends Fragment {


    private boolean mIsSliderCollapsed;
    private RecyclerView readingView;
    private View touchInterceptView;

    public ReadingViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsSliderCollapsed = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_reading_view, container, false);
     
        readingView = (RecyclerView) v.findViewById(R.id.reading_view);
        touchInterceptView = v.findViewById(R.id.touch_intercept_view);

        setupReadingView();

        final LinearLayout seekBarLayout = ((LinearLayout) v.findViewById(R.id.levelSliderFrame));
        final RelativeLayout hanziLayout = ((RelativeLayout) v.findViewById(R.id.hanziSlider));
        final RelativeLayout textSizeLayout = ((RelativeLayout) v.findViewById(R.id.alphaSlider));
        seekBarLayout.setAlpha(0.3f);
        LayoutTransition transition = new LayoutTransition();
        transition.setStagger(LayoutTransition.CHANGE_DISAPPEARING,100);
        transition.setStagger(LayoutTransition.CHANGE_APPEARING,100);
        transition.setStartDelay(LayoutTransition.DISAPPEARING, 50);
        transition.setDuration(LayoutTransition.APPEARING, 200);
        transition.setDuration(LayoutTransition.DISAPPEARING, 300);
        transition.setDuration(LayoutTransition.CHANGE_DISAPPEARING,100);
        transition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING, 300);
        transition.setDuration(LayoutTransition.CHANGE_APPEARING,200);
        seekBarLayout.setLayoutTransition(transition);
        final TickedSeekBar sb = ((TickedSeekBar)v.findViewById(R.id.levelSlider));
        sb.setEnabled(false);
        seekBarLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v2, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                  if(mIsSliderCollapsed){
                      touchInterceptView.setVisibility(View.VISIBLE);
                      hanziLayout.setVisibility(View.VISIBLE);
                      textSizeLayout.setVisibility(View.VISIBLE);
                      seekBarLayout.getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener() {
                          @Override
                          public void startTransition(LayoutTransition transition,
                                                      ViewGroup container, View view,
                                                      int transitionType) {
                          }

                          @Override
                          public void endTransition(LayoutTransition transition,
                                                    ViewGroup container, View view, int transitionType) {
                              if (view == hanziLayout) {
                                  seekBarLayout.setAlpha(1.0f);
                                  seekBarLayout.getLayoutTransition().removeTransitionListener(this);
                                  sb.setEnabled(true);
                              }
                          }
                      });
                      mIsSliderCollapsed = false;
                  }
                }
                return true;
            }
        });

        touchInterceptView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!mIsSliderCollapsed) {
                        touchInterceptView.setVisibility(View.GONE);
                        textSizeLayout.setVisibility(View.GONE);
                        hanziLayout.setVisibility(View.GONE);
                        seekBarLayout.getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener() {
                            @Override
                            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                            }

                            @Override
                            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                                if(view == hanziLayout){
                                    seekBarLayout.setAlpha(0.3f);
                                    seekBarLayout.getLayoutTransition().removeTransitionListener(this);
                                    sb.setEnabled(false);
                                }
                            }
                        });
                        mIsSliderCollapsed = true;
                    }
                }
                return true;
            }
        });
        return v;
    }

    private void setupReadingView() {
        final List<ReadingChunk> chunkList = new ArrayList<>();
        chunkList.add(new ReadingChunk(getActivity(), "he or him", "tā", "他"));
        chunkList.add(new ReadingChunk(getActivity(), "to shout", "jiào", "叫"));
        chunkList.add(new ReadingChunk(getActivity(), "surname Sun", "Sūn", "孙"));
        chunkList.add(new ReadingChunk(getActivity(), "double-edged sword", "jiàn", "剑"));
        chunkList.add(new ReadingChunk(getActivity(), "is", "shì", "是"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));
        chunkList.add(new ReadingChunk(getActivity(), "he or him", "tā", "他"));
        chunkList.add(new ReadingChunk(getActivity(), "to shout", "jiào", "叫"));
        chunkList.add(new ReadingChunk(getActivity(), "surname Sun", "Sūn", "孙"));
        chunkList.add(new ReadingChunk(getActivity(), "double-edged sword", "jiàn", "剑"));
        chunkList.add(new ReadingChunk(getActivity(), "is", "shì", "是"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));
        chunkList.add(new ReadingChunk(getActivity(), "he or him", "tā", "他"));
        chunkList.add(new ReadingChunk(getActivity(), "to shout", "jiào", "叫"));
        chunkList.add(new ReadingChunk(getActivity(), "surname Sun", "Sūn", "孙"));
        chunkList.add(new ReadingChunk(getActivity(), "double-edged sword", "jiàn", "剑"));
        chunkList.add(new ReadingChunk(getActivity(), "is", "shì", "是"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));
        chunkList.add(new ReadingChunk(getActivity(), "he or him", "tā", "他"));
        chunkList.add(new ReadingChunk(getActivity(), "to shout", "jiào", "叫"));
        chunkList.add(new ReadingChunk(getActivity(), "surname Sun", "Sūn", "孙"));
        chunkList.add(new ReadingChunk(getActivity(), "double-edged sword", "jiàn", "剑"));
        chunkList.add(new ReadingChunk(getActivity(), "is", "shì", "是"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));
        chunkList.add(new ReadingChunk(getActivity(), "he or him", "tā", "他"));
        chunkList.add(new ReadingChunk(getActivity(), "to shout", "jiào", "叫"));
        chunkList.add(new ReadingChunk(getActivity(), "surname Sun", "Sūn", "孙"));
        chunkList.add(new ReadingChunk(getActivity(), "double-edged sword", "jiàn", "剑"));
        chunkList.add(new ReadingChunk(getActivity(), "is", "shì", "是"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));
        chunkList.add(new ReadingChunk(getActivity(), "he or him", "tā", "他"));
        chunkList.add(new ReadingChunk(getActivity(), "to shout", "jiào", "叫"));
        chunkList.add(new ReadingChunk(getActivity(), "surname Sun", "Sūn", "孙"));
        chunkList.add(new ReadingChunk(getActivity(), "double-edged sword", "jiàn", "剑"));
        chunkList.add(new ReadingChunk(getActivity(), "is", "shì", "是"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));
        chunkList.add(new ReadingChunk(getActivity(), "he or him", "tā", "他"));
        chunkList.add(new ReadingChunk(getActivity(), "to shout", "jiào", "叫"));
        chunkList.add(new ReadingChunk(getActivity(), "surname Sun", "Sūn", "孙"));
        chunkList.add(new ReadingChunk(getActivity(), "double-edged sword", "jiàn", "剑"));
        chunkList.add(new ReadingChunk(getActivity(), "is", "shì", "是"));
        chunkList.add(new ReadingChunk(getActivity(), "trip", "lǔ:yóu", "旅游"));

        ReadingViewAdapter adapter = new ReadingViewAdapter(getActivity(), chunkList);

        readingView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 100);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                float spanSize = (chunkList.get(position).getWidth() / readingView.getWidth()) * 100;

                // check for span size of over 100% of width
                return Math.min((int) spanSize, 100);
            }
        };

        spanSizeLookup.setSpanIndexCacheEnabled(true);
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        readingView.setLayoutManager(layoutManager);
        readingView.setAdapter(adapter);

    }
}
