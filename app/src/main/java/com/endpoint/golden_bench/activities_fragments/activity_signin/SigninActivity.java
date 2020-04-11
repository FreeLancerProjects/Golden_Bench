package com.endpoint.golden_bench.activities_fragments.activity_signin;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_signin.fragments.Fragment_Signin;
import com.endpoint.golden_bench.activities_fragments.activity_signin.fragments.Fragment_Signin3;
import com.endpoint.golden_bench.activities_fragments.activity_signin.fragments.Fragment_Signin2;
import com.endpoint.golden_bench.adapter.ViewPagerAdapter;
import com.endpoint.golden_bench.databinding.ActivitySignInBinding;
import com.endpoint.golden_bench.language.Language;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class SigninActivity extends AppCompatActivity  {
    private ActivitySignInBinding binding;
    private String lang;
    private ViewPagerAdapter pagerAdapter;
    private Preferences preferences;
    private UserModel userModel;



    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", Locale.getDefault().getLanguage())));}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        initView();


    }

    private void initView() {
        preferences = Preferences.getInstance();
        binding.tab.setupWithViewPager(binding.pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragments(getFragments());
        binding.pager.setAdapter(pagerAdapter);




    }


    private List<Fragment> getFragments() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(Fragment_Signin.newInstance());
        fragmentList.add(Fragment_Signin2.newInstance());
        fragmentList.add(Fragment_Signin3.newInstance());

        return fragmentList;

    }






}