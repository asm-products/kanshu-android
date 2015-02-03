package com.kanshu.kanshu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kanshu.kanshu.R;
import com.kanshu.kanshu.model.ReadingChunk;

import java.util.List;

public class ReadingViewAdapter extends RecyclerView.Adapter<ReadingViewAdapter.ReadingViewHolder> {

    private Context context;
    private List<ReadingChunk> chunkList;

    public ReadingViewAdapter(Context context, List<ReadingChunk> chunkList) {
        this.context = context;
        this.chunkList = chunkList;
    }

    @Override
    public ReadingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_reading_view, parent, false);
        return new ReadingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReadingViewHolder holder, int position) {
        ReadingChunk chunk = chunkList.get(position);
        holder.top.setText(chunk.getPinyin());
        holder.middle.setText(chunk.getHanzi());
        holder.bottom.setText(chunk.getDefinition());
    }

    @Override
    public int getItemCount() {
        return chunkList.size();
    }

    public static class ReadingViewHolder extends RecyclerView.ViewHolder {
        public final TextView top;
        public final TextView middle;
        public final TextView bottom;

        public ReadingViewHolder(View view) {
            super(view);
            top = (TextView) view.findViewById(R.id.definition);
            middle = (TextView) view.findViewById(R.id.pinyin);
            bottom = (TextView) view.findViewById(R.id.hanzi);
        }
    }
}
