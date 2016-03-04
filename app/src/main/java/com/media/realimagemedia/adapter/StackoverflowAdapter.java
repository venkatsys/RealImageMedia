package com.media.realimagemedia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.media.realimagemedia.R;
import com.media.realimagemedia.model.StackOverflow;
import com.media.realimagemedia.utils.StringManipulation;

import java.util.List;

/**
 * Created by Venkat on 03-03-2016.
 */
public class StackoverflowAdapter extends RecyclerView.Adapter<StackoverflowAdapter.StackOverflowItems> {
    private Context _context;
    private List<StackOverflow> stackList;
    private LayoutInflater mInflater;
    private onItemClickListener _mOnitemClick;
    public StackoverflowAdapter(Context context, List<StackOverflow> stackItems){
        this._context = context;
        this.stackList = stackItems;
        this.mInflater = LayoutInflater.from(this._context);
    }

    @Override
    public StackOverflowItems onCreateViewHolder(ViewGroup parent, int viewType) {
        View _mView = mInflater.inflate(R.layout.stackoverflow_items, parent, false);
        StackOverflowItems mRemoteItems = new StackOverflowItems(_mView);
        return mRemoteItems;
    }

    @Override
    public void onBindViewHolder(StackOverflowItems holder, int position) {
        StackOverflow myStckItems = this.stackList.get(position);
        holder.stackIVotes.setText(myStckItems.getQuestionscore());
        holder.stackTgName.setText(myStckItems.getQuestiontagname());
        holder.stackIAnswer.setText(myStckItems.getQuestionanswercount());
        holder.stackIViews.setText(myStckItems.getQuestionviewcount());
        holder.stackITitle.setText(myStckItems.getQuestiontitle());
        holder.stackITime.setText(StringManipulation.getTimeAgo(Long.valueOf(myStckItems.getQuestiontime())) + "    " + myStckItems.getQuestionauthorname());
    }

    @Override
    public int getItemCount() {
        return this.stackList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class StackOverflowItems extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView stackIVotes,stackIAnswer,stackIViews,stackITitle,stackITime,stackTgName;
        LinearLayout parentLayout;

        public StackOverflowItems(View itemView) {
            super(itemView);
            stackIVotes = (TextView) itemView.findViewById(R.id.stackVote);
            stackIAnswer = (TextView) itemView.findViewById(R.id.stackAnswer);
            stackIViews = (TextView) itemView.findViewById(R.id.stackViews);
            stackITitle = (TextView) itemView.findViewById(R.id.stackTitle);
            stackITime = (TextView) itemView.findViewById(R.id.stackTime);
            stackTgName = (TextView) itemView.findViewById(R.id.stackTagName);
            stackTgName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (_mOnitemClick != null) {
                _mOnitemClick.onItemClick(v, getAdapterPosition());
            }
        }
    }
    public interface onItemClickListener {
        public void onItemClick(View v, int position);
    }

    public void SetonItemClickListener(final onItemClickListener mItemClickListener) {
        this._mOnitemClick = mItemClickListener;
    }


}
