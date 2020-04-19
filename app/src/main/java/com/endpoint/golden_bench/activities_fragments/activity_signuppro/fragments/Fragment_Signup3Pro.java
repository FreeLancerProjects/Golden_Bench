package com.endpoint.golden_bench.activities_fragments.activity_signuppro.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_pro.HomeProActivity;
import com.endpoint.golden_bench.activities_fragments.activity_signuppro.SignupProActivity;
import com.endpoint.golden_bench.databinding.FragmentSignUp3ProBinding;

public class Fragment_Signup3Pro extends Fragment {
    private SignupProActivity activity;
    private FragmentSignUp3ProBinding binding;


    public static Fragment_Signup3Pro newInstance() {
        return new Fragment_Signup3Pro();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up3_pro, container, false);
        initView();

        return binding.getRoot();
    }

    private void initView() {
        activity=(SignupProActivity)getActivity();
binding.btnSkip.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(activity, HomeProActivity.class);
        startActivity(intent);
    }
});
    }


}
