package com.media.realimagemedia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.media.realimagemedia.R;

import java.util.List;

/**
 * Created by Venkat on 04-03-2016.
 */
public class StackTagAdapter extends RecyclerView.Adapter<StackTagAdapter.TagAdapter> {

    private LayoutInflater inflater;
    private List<String> tagList;
    private onTagItemClickListerner mItemClickListener;

    public StackTagAdapter(Context context, List<String> tagsList) {
        this.inflater = LayoutInflater.from(context);
        this.tagList = tagsList;

    }

    @Override
    public TagAdapter onCreateViewHolder(ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.stack_tag_name, parent, false);
        TagAdapter deviceAdapter = new TagAdapter(view);
        return deviceAdapter;
    }

    @Override
    public void onBindViewHolder(TagAdapter viewHolder, int position) {
        viewHolder.tagtitle.setText(this.tagList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.tagList.size();
    }

    public class TagAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tagtitle;

        public TagAdapter(View itemView) {
            super(itemView);
            tagtitle = (TextView) itemView.findViewById(R.id.stackNameList);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mItemClickListener != null){
                mItemClickListener.onItemClick(v , getAdapterPosition());
            }
        }
    }

    /**
     * Create a listener for new item click
     */
    public interface onTagItemClickListerner {
        public void onItemClick(View v, int position);
    }

    /**
     * Registered the Item click listener
     */
    public void SetonItemClickListener(final onTagItemClickListerner mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
