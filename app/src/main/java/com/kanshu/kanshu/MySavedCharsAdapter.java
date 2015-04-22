package com.kanshu.kanshu;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kanshu.kanshu.model.SavedChars;
import com.kanshu.kanshu.model.User;

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

        public TextView CharTV;
        public TextView CharDescriptionTV;
        public ImageView DeleteBtn;

        public SavedChars single_char = null;

        public void DeleteChar (String id){
            if(single_char != null && single_char.getWordID() >= 0)
                single_char.delete(id);
            SavedCharsList.remove(getPosition());
            notifyItemRemoved(getPosition());
            notifyItemRangeChanged(getPosition(), SavedCharsList.size());
        }

        public SavedCharViewHolder(View v) {
            super(v);
            single_char = new SavedChars();
            CharTV = (TextView) v.findViewById(R.id.saved_char);
            CharDescriptionTV = (TextView) v.findViewById(R.id.saved_char_description);
            DeleteBtn = (ImageView) v.findViewById(R.id.delete_char);
            final SavedCharViewHolder holder = this;
            DeleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity a = (Activity)v.getContext();
                    User loggedInUser = a.getIntent().getExtras().getParcelable("user");
                    holder.DeleteChar(loggedInUser.getSessionId());
                }
            });
        }
    }


    public MySavedCharsAdapter(List<SavedChars> lst) {
        SavedCharsList = lst;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_saved_chars, parent, false);

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
        ((SavedCharViewHolder)holder).CharTV.setText(single_char.getChar());
        ((SavedCharViewHolder)holder).CharDescriptionTV.setText(single_char.getChardescription());
        ((SavedCharViewHolder)holder).single_char = single_char;

    }

    @Override
    public int getItemCount() {
        return SavedCharsList.size();
    }
}