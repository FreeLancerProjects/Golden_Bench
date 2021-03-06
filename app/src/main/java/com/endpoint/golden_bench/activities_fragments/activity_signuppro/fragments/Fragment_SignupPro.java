package com.endpoint.golden_bench.activities_fragments.activity_signuppro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_signuppro.SignupProActivity;
import com.endpoint.golden_bench.databinding.FragmentSignUpProBinding;
import com.endpoint.golden_bench.preferences.Preferences;

public class Fragment_SignupPro extends Fragment {

    private SignupProActivity activity;
    private FragmentSignUpProBinding binding;
    private Preferences preferences;


    public static Fragment_SignupPro newInstance() {
        return new Fragment_SignupPro();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up_pro, container, false);
        initView();

        return binding.getRoot();
    }

    private void initView() {

    }


}
