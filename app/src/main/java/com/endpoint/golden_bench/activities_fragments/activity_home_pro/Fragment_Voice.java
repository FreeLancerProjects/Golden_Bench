package com.endpoint.golden_bench.activities_fragments.activity_home_pro;

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
import com.endpoint.golden_bench.adapter.Voice_Adapter;
import com.endpoint.golden_bench.databinding.FragmentVoiceBinding;
import com.endpoint.golden_bench.models.MarketCatogryModel;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_Voice extends Fragment {

    private HomeproActivity activity;
    private FragmentVoiceBinding binding;
    private Preferences preferences;

    private String lang;
    private List<MarketCatogryModel.Data> dataList;
    private Voice_Adapter categorys_adapter;

    public static Fragment_Voice newInstance() {
        return new Fragment_Voice();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_voice,container,false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        dataList = new ArrayList<>();


        activity = (HomeproActivity) getActivity();
        Paper.init(activity);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());preferences = Preferences.getInstance();


        categorys_adapter = new Voice_Adapter(dataList, activity);

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


    @Override
    public void onResume() {
        super.onResume();
    }
}
