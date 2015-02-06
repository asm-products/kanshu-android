package com.kanshu.kanshu;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kanshu.kanshu.model.SavedChars;
import com.kanshu.kanshu.widget.ChineseTextView;

import java.util.List;

/**
 * Created by alouanemed on 06-02-2015.
 */
public class MySavedCharsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SavedChars> SavedCharsList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class SavedCharViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public ChineseTextView CharTV;
        public TextView CharDescriptionTV;
        public ImageView DeleteBtn;
        public CardView cardView;

        public SavedChars single_char;

        public SavedCharViewHolder(View v) {
            super(v);
            single_char = new SavedChars();
            CharTV = (ChineseTextView) v.findViewById(R.id.saved_char);
            CharDescriptionTV = (TextView) v.findViewById(R.id.saved_char_description);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }


    public MySavedCharsAdapter(List<SavedChars> lst) {
        SavedCharsList = lst;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_chars_card, parent, false);

        RecyclerView.ViewHolder vh = new SavedCharViewHolder(v);
        return vh;
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
        SavedChars single_char = SavedCharsList.get(position);
        //@todo set the real data here.
        // holder.titleTextView.setText(article.getTitle())
        // For illustrative purpose, do nothing here

    }

    @Override
    public int getItemCount() {
        return SavedCharsList.size();
    }
}