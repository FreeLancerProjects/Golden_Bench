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
import com.endpoint.golden_bench.activities_fragments.activity_signup.SignupActivity;
import com.endpoint.golden_bench.databinding.FragmentSignUp3FollowBinding;
import com.endpoint.golden_bench.databinding.FragmentSignUpFollowBinding;
import com.endpoint.golden_bench.preferences.Preferences;

public class Fragment_SignupFollow extends Fragment {

    private SignupActivity activity;
    private FragmentSignUpFollowBinding binding;
    private Preferences preferences;


    public static Fragment_SignupFollow newInstance() {
        return new Fragment_SignupFollow();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up_follow, container, false);
        initView();

        return binding.getRoot();
    }

    private void initView() {

    }


}
