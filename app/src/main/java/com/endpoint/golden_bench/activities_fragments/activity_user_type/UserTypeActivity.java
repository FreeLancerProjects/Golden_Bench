package com.endpoint.golden_bench.activities_fragments.activity_user_type;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_signup.SignupActivity;
import com.endpoint.golden_bench.activities_fragments.activity_signup.fragments.Fragment_Signup2Follow;
import com.endpoint.golden_bench.activities_fragments.activity_signup.fragments.Fragment_Signup3Follow;
import com.endpoint.golden_bench.activities_fragments.activity_signup.fragments.Fragment_SignupFollow;
import com.endpoint.golden_bench.activities_fragments.activity_signuppro.SignupProActivity;
import com.endpoint.golden_bench.adapter.ViewPagerAdapter;
import com.endpoint.golden_bench.databinding.ActivitySignUpBinding;
import com.endpoint.golden_bench.databinding.ActivityUserTypeBinding;
import com.endpoint.golden_bench.language.Language;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class UserTypeActivity extends AppCompatActivity  {
    private ActivityUserTypeBinding binding;
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_type);

        initView();


    }

    private void initView() {
        preferences = Preferences.getInstance();

binding.fab.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(binding.rbPro.isChecked()){
            Intent intent=new Intent(UserTypeActivity.this, SignupProActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent=new Intent(UserTypeActivity.this, SignupActivity.class);
            startActivity(intent);
        }
    }
});


    }









}
