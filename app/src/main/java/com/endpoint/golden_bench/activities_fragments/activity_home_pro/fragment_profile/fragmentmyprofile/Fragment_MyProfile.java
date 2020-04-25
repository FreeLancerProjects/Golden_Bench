package com.endpoint.golden_bench.activities_fragments.activity_home_pro.fragment_profile.fragmentmyprofile;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_pro.HomeproActivity;
import com.endpoint.golden_bench.adapter.ViewPagerTitleAdapter;
import com.endpoint.golden_bench.databinding.FragmentProfileBinding;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_MyProfile extends Fragment {
    private static Dialog dialog;
    private HomeproActivity activity;
    private FragmentProfileBinding binding;
    private String lang;
    private List<Fragment> fragmentList;
    private List<String> titles;
    private ViewPagerTitleAdapter adapter;

    private Preferences preferences;
    private UserModel userModel;

    public static Fragment_MyProfile newInstance() {
        return new Fragment_MyProfile();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        initView();


        return binding.getRoot();
    }


    private void initView() {
        activity = (HomeproActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        binding.tab.setupWithViewPager(binding.pager);
        addFragments_Titles();
        binding.pager.setOffscreenPageLimit(fragmentList.size());
        adapter = new ViewPagerTitleAdapter(getChildFragmentManager());
        adapter.addFragments(fragmentList);
        adapter.addTitles(titles);
        binding.pager.setAdapter(adapter);


    }

    private void addFragments_Titles() {
        fragmentList.add(FragmentBlog.newInstance());
        fragmentList.add(FragmentMyVoice.newInstance());
        fragmentList.add(FragmentPhoto.newInstance());


        titles.add(getString(R.string.myblog));
        titles.add(getString(R.string.voice));
        titles.add(getString(R.string.photos));

    }

}
