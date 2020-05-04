package com.endpoint.golden_bench.activities_fragments.activity_terms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_signup.SignupActivity;
import com.endpoint.golden_bench.activities_fragments.activity_signuppro.SignupProActivity;
import com.endpoint.golden_bench.adapter.ViewPagerAdapter;
import com.endpoint.golden_bench.databinding.ActivityTermsBinding;
import com.endpoint.golden_bench.databinding.ActivityUserTypeBinding;
import com.endpoint.golden_bench.language.Language;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import io.paperdb.Paper;

public class TermsActivity extends AppCompatActivity  {
    private ActivityTermsBinding binding;
    private String lang;
    private ViewPagerAdapter pagerAdapter;
    private Preferences preferences;
    private UserModel userModel;



    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_terms);

        initView();


    }

    private void initView() {
        preferences = Preferences.getInstance();




    }









}
