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
import com.endpoint.golden_bench.databinding.FragmentSignUp2ProBinding;

public class Fragment_Signup2Pro extends Fragment {

    private SignupProActivity activity;
    private FragmentSignUp2ProBinding binding;


    public static Fragment_Signup2Pro newInstance() {
        return new Fragment_Signup2Pro();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up2_pro,container,false);
        initView();

        return binding.getRoot();
    }

    private void initView() {


    }


}
