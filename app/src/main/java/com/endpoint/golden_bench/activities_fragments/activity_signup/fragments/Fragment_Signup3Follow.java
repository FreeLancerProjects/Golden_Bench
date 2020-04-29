package com.endpoint.golden_bench.activities_fragments.activity_signup.fragments;

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
import com.endpoint.golden_bench.activities_fragments.activity_home_follow.HomeFollowerActivity;
import com.endpoint.golden_bench.activities_fragments.activity_signup.SignupActivity;
import com.endpoint.golden_bench.databinding.FragmentSignUp3FollowBinding;

public class Fragment_Signup3Follow extends Fragment {
    private SignupActivity activity;
    private FragmentSignUp3FollowBinding binding;


    public static Fragment_Signup3Follow newInstance() {
        return new Fragment_Signup3Follow();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up3_follow, container, false);
        initView();

        return binding.getRoot();
    }

    private void initView() {
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HomeFollowerActivity.class);
                startActivity(intent);
            }
        });

    }


}
