package com.endpoint.golden_bench.activities_fragments.activity_home_player.fragments.fragment_profile;

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
import com.endpoint.golden_bench.adapter.Photo_Adapter;
import com.endpoint.golden_bench.adapter.Photos_Adapter;
import com.endpoint.golden_bench.adapter.Team_Adapter;
import com.endpoint.golden_bench.adapter.ViewPagerTitleAdapter;

import com.endpoint.golden_bench.databinding.FragmentProfilePlayerBinding;
import com.endpoint.golden_bench.models.MarketCatogryModel;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_Profile extends Fragment {
    private static Dialog dialog;
    private HomeplayerActivity activity;
    private FragmentProfilePlayerBinding binding;
    private String lang;


    private Preferences preferences;
    private UserModel userModel;
    private Photo_Adapter category_adapter;
    private Photos_Adapter photos_adapter;
    private Team_Adapter team_adapter;

    private List<MarketCatogryModel.Data> dataList;

    public static Fragment_Profile newInstance() {
        return new Fragment_Profile();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_player, container, false);
        initView();


        return binding.getRoot();
    }


    private void initView() {
        dataList=new ArrayList<>();
        activity = (HomeplayerActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());



        category_adapter = new Photo_Adapter(dataList, activity);
        photos_adapter = new Photos_Adapter(dataList, activity);
        team_adapter = new Team_Adapter(dataList, activity);

        binding.recview1.setLayoutManager(new LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false));
        binding.recview1.setAdapter(category_adapter);
        binding.recView.setLayoutManager(new LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false));
        binding.recView.setAdapter(photos_adapter);
        binding.recview3.setLayoutManager(new LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false));
        binding.recView2.setLayoutManager(new LinearLayoutManager(activity));
        binding.recview3.setAdapter(photos_adapter);
        binding.recView2.setAdapter(team_adapter);

//        binding.recservice.setLayoutManager(new LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false));
//        binding.recservice.setAdapter(categorys_adapter);
//        binding.progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
//        binding.progBarservice.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
//
//        binding.progBar.setVisibility(View.GONE);
//        binding.progBarservice.setVisibility(View.GONE);
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
        photos_adapter.notifyDataSetChanged();
team_adapter.notifyDataSetChanged();
    }




}
