package com.endpoint.golden_bench.activities_fragments.activity_signup.fragments;

import android.content.Intent;
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
import com.endpoint.golden_bench.activities_fragments.activity_signup.SignupActivity;
import com.endpoint.golden_bench.adapter.Choose_Adapter;
import com.endpoint.golden_bench.adapter.Voice_Adapter;
import com.endpoint.golden_bench.databinding.FragmentSignUp3FollowBinding;
import com.endpoint.golden_bench.models.MarketCatogryModel;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Signup3Follow extends Fragment {
    private SignupActivity activity;
    private FragmentSignUp3FollowBinding binding;
    private List<MarketCatogryModel.Data> dataList;
    private Choose_Adapter categorys_adapter;

    public static Fragment_Signup3Follow newInstance() {
        return new Fragment_Signup3Follow();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up3_follow, container, false);
        initView();

        return binding.getRoot();
    }

    private void initView() {
        dataList=new ArrayList<>();
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HomeFollowerActivity.class);
                startActivity(intent);
            }
        });

        categorys_adapter = new Choose_Adapter(dataList, getActivity());

        binding.recVtiew.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recVtiew.setAdapter(categorys_adapter);

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
