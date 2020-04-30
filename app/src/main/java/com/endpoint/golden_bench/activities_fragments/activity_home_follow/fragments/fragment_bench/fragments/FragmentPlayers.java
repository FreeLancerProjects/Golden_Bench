package com.endpoint.golden_bench.activities_fragments.activity_home_follow.fragments.fragment_bench.fragments;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_follow.HomeFollowerActivity;
import com.endpoint.golden_bench.adapter.Agent_Adapter;
import com.endpoint.golden_bench.adapter.Player_Adapter;
import com.endpoint.golden_bench.adapter.Voice_Adapter;
import com.endpoint.golden_bench.databinding.FragmentOrdersBinding;
import com.endpoint.golden_bench.models.MarketCatogryModel;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class FragmentPlayers extends Fragment {
    private HomeFollowerActivity activity;
    private FragmentOrdersBinding binding;
    private Preferences preferences;
    private List<MarketCatogryModel.Data> dataList;
    private Player_Adapter categorys_adapter;
private UserModel userModel;

    public static FragmentPlayers newInstance()
    {
        return new FragmentPlayers();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders,container,false);
        initView();

        return binding.getRoot();
    }

    private void initView() {
        dataList = new ArrayList<>();


        activity = (HomeFollowerActivity) getActivity();
        Paper.init(activity);



        categorys_adapter = new Player_Adapter(dataList, activity);

        binding.recView.setLayoutManager(new LinearLayoutManager(activity));
        binding.recView.setAdapter(categorys_adapter);
        binding.progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);

        binding.progBar.setVisibility(View.GONE);
        Adddata();

    }

    private void Adddata() {
        dataList.add(new MarketCatogryModel.Data());
        dataList.add(new MarketCatogryModel.Data());
        dataList.add(new MarketCatogryModel.Data());
        dataList.add(new MarketCatogryModel.Data());
        dataList.add(new MarketCatogryModel.Data());
        dataList.add(new MarketCatogryModel.Data());
        dataList.add(new MarketCatogryModel.Data());
        dataList.add(new MarketCatogryModel.Data());
        categorys_adapter.notifyDataSetChanged();

    }

}
