package com.endpoint.golden_bench.activities_fragments.activity_home_player.fragments;

import android.app.Dialog;
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
import androidx.recyclerview.widget.RecyclerView;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_player.HomeplayerActivity;
import com.endpoint.golden_bench.adapter.Category_Adapter;
import com.endpoint.golden_bench.adapter.Categorys_Adapter;
import com.endpoint.golden_bench.databinding.FragmnetMainBinding;
import com.endpoint.golden_bench.models.MarketCatogryModel;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_Main extends Fragment {
    private static Dialog dialog;
    private HomeplayerActivity activity;
    private FragmnetMainBinding binding;
    private LinearLayoutManager manager, manager2;
    private Preferences preferences;


    private String lang;
    private Category_Adapter category_adapter;
    private List<MarketCatogryModel.Data> dataList;
    private Categorys_Adapter categorys_adapter;
    public static Fragment_Main newInstance() {
        return new Fragment_Main();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragmnet_main, container, false);
        initView();

        return binding.getRoot();
    }



    private void initView() {

        dataList = new ArrayList<>();

        activity = (HomeplayerActivity) getActivity();
        preferences = Preferences.getInstance();
        Paper.init(activity);
         lang = Paper.book().read("lang", Locale.getDefault().getLanguage());


        category_adapter = new Category_Adapter(dataList, activity);
        categorys_adapter = new Categorys_Adapter(dataList, activity);

        binding.recBestseler.setLayoutManager(new LinearLayoutManager(activity));
        binding.recBestseler.setAdapter(category_adapter);
        binding.recservice.setLayoutManager(new LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false));
        binding.recservice.setAdapter(categorys_adapter);
        binding.progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        binding.progBarservice.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        binding.progBar.setVisibility(View.GONE);
        binding.progBarservice.setVisibility(View.GONE);
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
        category_adapter.notifyDataSetChanged();
        categorys_adapter.notifyDataSetChanged();

    }


}
