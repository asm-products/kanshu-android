package com.kanshu.android.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.kanshu.android.R;
import com.kanshu.android.model.Article;

import java.util.List;

/**
 * Created by zhou on 1/15/15.
 */
public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Article> articleList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        // add image source later
        public TextView titleTextView;
        public TextView summaryTextView;
        public ListView commentListView;
        public ImageView commentButton;
        public TextView commentText;
        public ImageView likeButton;
        public TextView likeTextView;
        public CardView cardView;
        public LinearLayout commentLayout;

        //data
        public Article article;

        private final int ANIMATION_SPEED = 300;

        public ArticleViewHolder(View v) {
            super(v);
            article = new Article();

            titleTextView = (TextView) v.findViewById(R.id.article_title);
            summaryTextView = (TextView) v.findViewById(R.id.article_summary);
            cardView = (CardView) v.findViewById(R.id.card_view);
            likeButton = (ImageView) v.findViewById(R.id.article_card_like_button);
            likeTextView = (TextView) v.findViewById(R.id.article_card_like_text);
            commentLayout = (LinearLayout) v.findViewById((R.id.article_card_comment_layout));
            commentButton = (ImageView) v.findViewById(R.id.article_card_comment_button);
            commentText = (TextView) v.findViewById(R.id.article_comment_text);
            //deal with like
            //convert the number to string otherwise the setText would think the int is an
            // resource id
            likeTextView.setText("" + article.getLike());
            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    article.setLike(article.getLike() + 1);
                    likeTextView.setText("" + article.getLike());
                }
            });
            //deal with comment
            View.OnClickListener commentListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final float scale = v.getContext().getResources().getDisplayMetrics().density;
                    float height = (int) (140 * scale + 0.5f);
                    if (commentLayout.getVisibility() == View.VISIBLE) {
                        //recale the cardview and comment layout at the same time
                        ValueAnimator va = ValueAnimator.ofInt(cardView.getHeight(), (int) height);
                        va.setDuration(ANIMATION_SPEED);
                        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator animation) {
                                Integer value = (Integer) animation.getAnimatedValue();
                                cardView.getLayoutParams().height = value.intValue();
                                cardView.requestLayout();
                            }
                        });
                        va.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                commentButton.setImageResource(R.drawable.ic_triangle_light_grey);
                                commentButton.refreshDrawableState();
                                commentLayout.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }

                        });
                        ValueAnimator va2 = ValueAnimator.ofInt(commentLayout.getHeight(), 0);
                        va2.setDuration(ANIMATION_SPEED);
                        va2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator animation) {
                                Integer value = (Integer) animation.getAnimatedValue();
                                commentLayout.getLayoutParams().height = value.intValue();
                                commentLayout.requestLayout();
                            }
                        });

                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.play(va).with(va2);
                        animatorSet.start();

                    } else {
                        commentLayout.setVisibility(View.VISIBLE);
                        height = (int) (340 * scale + 0.5f);
                        ValueAnimator va3 = ValueAnimator.ofInt(cardView.getHeight(), (int) height);
                        va3.setDuration(ANIMATION_SPEED);
                        va3.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                commentButton.setImageResource(R.drawable.ic_triangle_light_red);
                                commentButton.refreshDrawableState();
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                        va3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator animation) {
                                Integer value = (Integer) animation.getAnimatedValue();
                                cardView.getLayoutParams().height = value.intValue();
                                cardView.requestLayout();
                            }
                        });
                        ValueAnimator va4 = ValueAnimator.ofInt(0, (int) (200 * scale + 0.5f));
                        va4.setDuration(ANIMATION_SPEED);
                        va4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator animation) {
                                Integer value = (Integer) animation.getAnimatedValue();
                                commentLayout.getLayoutParams().height = value.intValue();
                                commentLayout.requestLayout();
                            }
                        });

                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.play(va3).with(va4);
                        animatorSet.start();
                    }
                }
            };

            commentButton.setOnClickListener(commentListener);
            commentText.setOnClickListener(commentListener);

            String[] dummy_data = {"1", "2", "3", "4", "5"};
            ArticleListCommentAdapter adapter = new ArticleListCommentAdapter(v.getContext(),
                    dummy_data);
            commentListView = (ListView) v.findViewById(R.id.article_card_comment_list);
            commentListView.setAdapter(adapter);
            //let listview intercept scrolling gesture
            commentListView.setOnTouchListener(new ListView.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    switch (action) {
                        case MotionEvent.ACTION_DOWN:
                            // Disallow ScrollView to intercept touch events.
                            v.getParent().requestDisallowInterceptTouchEvent(true);
                            break;

                        case MotionEvent.ACTION_UP:
                            // Allow ScrollView to intercept touch events.
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }

                    // Handle ListView touch events.
                    v.onTouchEvent(event);
                    return true;
                }
            });
        }
    }

    public class IndicatorViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        // add image source later
        public TextView indicatorTextView;

        public IndicatorViewHolder(View v) {
            super(v);
            indicatorTextView = (TextView) v.findViewById(R.id.article_indicator);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ArticleAdapter(List<Article> lst) {
        articleList = lst;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        switch (viewType) {
            case 1:
                // create a new view
                View v2 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.date_indicator, parent, false);
                RecyclerView.ViewHolder vh2 = new IndicatorViewHolder(v2);
                return vh2;
            default:
                // create a new view
                View v1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.article_card, parent, false);
                RecyclerView.ViewHolder vh1 = new ArticleViewHolder(v1);
                return vh1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        //@todo replace this with a real get item new type method based on the real data
        //right now I would just make every 5th card an indicator
        if (position % 5 == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Article article = articleList.get(position);
        //@todo set the real data here.
        // holder.titleTextView.setText(article.getTitle())
        // For illustrative purpose, do nothing here

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return articleList.size();
    }
}