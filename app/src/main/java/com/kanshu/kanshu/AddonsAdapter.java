package com.kanshu.kanshu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.kanshu.kanshu.model.Addon;
import com.kanshu.kanshu.model.Exercise;

import java.util.List;

/**
 * Created by alouanemed on 12-02-2015.
 */
public class AddonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Addon> mAddonlist;


    public class UserAddonsViewHolder extends RecyclerView.ViewHolder {

        public TextView addonTitleTV;
        public TextView addonDescriptionTV;
        public TextView addonInfosTV;//refers to  additional informations such as price ,size ...
        public ImageView addonThumbIV;
        public ImageButton addonBuyBtn;
        public ImageButton addonDeleteBtn;

        public Addon mAddon;

        public UserAddonsViewHolder(View v) {
            super(v);
            mAddon = new Addon();
            addonTitleTV = (TextView) v.findViewById(R.id.addon_title);
            addonDescriptionTV = (TextView) v.findViewById(R.id.addon_description);
            addonInfosTV = (TextView) v.findViewById(R.id.addon_info);
            addonThumbIV = (ImageView) v.findViewById(R.id.addon_thumbnail);
            addonBuyBtn = (ImageButton) v.findViewById(R.id.addon_delete);
            addonDeleteBtn = (ImageButton) v.findViewById(R.id.addon_buy);
        }
    }


    public AddonsAdapter(List<Addon> lst) {
        mAddonlist = lst;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_addons, parent, false);

        RecyclerView.ViewHolder vh = new UserAddonsViewHolder(v);
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
        Addon _mAddon = mAddonlist.get(position);
        //@todo set the real data here.

    }

    @Override
    public int getItemCount() {
        return mAddonlist.size();
    }
}