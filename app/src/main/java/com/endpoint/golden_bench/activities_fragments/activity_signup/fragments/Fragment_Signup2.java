package com.endpoint.golden_bench.activities_fragments.activity_signup.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_signin.SigninActivity;
import com.endpoint.golden_bench.activities_fragments.activity_signup.SignupActivity;
import com.endpoint.golden_bench.databinding.FragmentSignIn2Binding;
import com.endpoint.golden_bench.databinding.FragmentSignUp2Binding;

public class Fragment_Signup2 extends Fragment {

    private SignupActivity activity;
    private FragmentSignUp2Binding binding;


    public static Fragment_Signup2 newInstance() {
        return new Fragment_Signup2();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up2,container,false);
        initView();

        return binding.getRoot();
    }

    private void initView() {


    }


}
