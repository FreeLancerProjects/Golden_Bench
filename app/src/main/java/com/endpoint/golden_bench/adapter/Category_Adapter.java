package com.endpoint.golden_bench.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.databinding.PostRowBinding;
import com.endpoint.golden_bench.databinding.PostvideoRowBinding;
import com.endpoint.golden_bench.models.MarketCatogryModel;

import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Category_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int ITEM_MESSAGE_LEFT = 1;
    private final int ITEM_MESSAGE_RIGHT = 2;
    private List<MarketCatogryModel.Data> orderlist;
    private Context context;
    private LayoutInflater inflater;
    private String lang;
    public Category_Adapter(List<MarketCatogryModel.Data> orderlist, Context context) {
        this.orderlist = orderlist;
        this.context = context;
        inflater = LayoutInflater.from(context);
        Paper.init(context);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if (viewType == ITEM_MESSAGE_LEFT) {

            PostvideoRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.postvideo_row, parent, false);
            return new EventHolder(binding);

        } else {

            PostRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.post_row, parent, false);
            return new EventsHolder(binding);

        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof EventHolder) {

            EventHolder msgLeftHolder = (EventHolder) holder;
            MediaController mc = new MediaController(context);
            msgLeftHolder.binding.videoview.setMediaController(mc);

            msgLeftHolder.binding.videoview.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
//msgLeftHolder.binding.videoview.requestFocus();
msgLeftHolder.binding.videoview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});

        } else if (holder instanceof EventsHolder) {
            EventsHolder msgRightHolder = (EventsHolder) holder;



        }
/*
if(i==position){
    if(i!=0) {
        if (((EventHolder) holder).binding.expandLayout.isExpanded()) {
            ((EventHolder) holder).binding.tvTitle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ((EventHolder) holder).binding.recView.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
            ((EventHolder) holder).binding.expandLayout.collapse(true);
            ((EventHolder) holder).binding.expandLayout.setVisibility(View.GONE);



        }
        else {

          //  ((EventHolder) holder).binding.tvTitle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ((EventHolder) holder).binding.recView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            ((EventHolder) holder).binding.expandLayout.setVisibility(View.VISIBLE);

           ((EventHolder) holder).binding.expandLayout.expand(true);
        }
    }
    else {
        eventHolder.binding.tvTitle.setBackground(activity.getResources().getDrawable(R.drawable.linear_bg_green));

        ((EventHolder) holder).binding.tvTitle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        ((EventHolder) holder).binding.recView.setLayoutParams(new FrameLayout.LayoutParams(0, 0));

    }
}
if(i!=position) {
    eventHolder.binding.tvTitle.setBackground(activity.getResources().getDrawable(R.drawable.linear_bg_white));
    ((EventHolder) holder).binding.tvTitle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

    ((EventHolder) holder).binding.recView.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
    ((EventHolder) holder).binding.expandLayout.collapse(true);


}*/

    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder {
        public PostvideoRowBinding binding;

        public EventHolder(@NonNull PostvideoRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
    public class EventsHolder extends RecyclerView.ViewHolder {
        public PostRowBinding binding;

        public EventsHolder(@NonNull PostRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
    @Override
    public int getItemViewType(int position) {



            if (position%2==0) {
                return ITEM_MESSAGE_LEFT;

            } else {


                return ITEM_MESSAGE_RIGHT;

            }



    }
}
